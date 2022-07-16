package model.entitites;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.concurrent.TimeUnit;

public class Reservar {
	
	private Integer numeroQuarto;
	private Date checkIn;
	private Date checkOut;
	
	private static SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
	
	
	public Reservar(Integer numeroQuarto, Date checkIn, Date checkOut) {
		this.numeroQuarto = numeroQuarto;
		this.checkIn = checkIn;
		this.checkOut = checkOut;
	}


	public Integer getNumeroQuarto() {
		return numeroQuarto;
	}


	public void setNumeroQuarto(Integer numeroQuarto) {
		this.numeroQuarto = numeroQuarto;
	}


	public Date getCheckIn() {
		return checkIn;
	}
	
	public Date getCheckOut() {
		return checkOut;
	}

	//Diferença entre datas
	public long duration() {
		long diff = checkOut.getTime() - checkIn.getTime();//milisegundos
		return TimeUnit.DAYS.convert(diff,TimeUnit.MILLISECONDS); //converte milisegundos para dias
		
	}
	
	public String updateDates(Date checkIn, Date checkOut) {
		
		Date now = new Date();
		
		if(checkIn.before(now) || checkOut.before(now)) {
			return "Erro na reserva: datas precisam ser datas neste ano ou no próximo";
		}
		
	    if(!checkOut.after(checkIn)) {
			return "Erro na reserva: data de Check-Out precisa ser depois da "
					+ "data de Check-In";
		}
		this.checkIn = checkIn;
		this.checkOut = checkOut;
		return null; /*não deu nenhum erro*/
	}
	
	@Override
	public String toString() {
		return "Quarto "
				+numeroQuarto
				+", check-in: "
				+sdf.format(checkIn)
				+", check-out: "
				+sdf.format(checkOut) 
				+", "
				+duration()
				+" noites";
	}
	
	

}
