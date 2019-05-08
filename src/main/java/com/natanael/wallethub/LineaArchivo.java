package com.natanael.wallethub;

import java.time.LocalDateTime;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table
public class LineaArchivo {
	
	@Id
	@GeneratedValue
	private Long id;
	private LocalDateTime fecha;
    private String ip;
    private String metodoHttp;
    private int codigoEstatus;
    private String userAgent;

    
    public LineaArchivo() {
	}

	public LineaArchivo(LocalDateTime fecha, String ip, String metodoHttp, int codigoEstatus, String userAgent) {
        this.fecha = fecha;
        this.ip = ip;
        this.metodoHttp = metodoHttp;
        this.codigoEstatus = codigoEstatus;
        this.userAgent = userAgent;
    }

	public LocalDateTime getFecha() {
        return fecha;
    }

    public void setFecha(LocalDateTime fecha) {
        this.fecha = fecha;
    }

    public String getIp() {
        return ip;
    }

    public void setIp(String ip) {
        this.ip = ip;
    }

    public String getMetodoHttp() {
        return metodoHttp;
    }

    public void setMetodoHttp(String metodoHttp) {
        this.metodoHttp = metodoHttp;
    }

    public int getCodigoEstatus() {
        return codigoEstatus;
    }

    public void setCodigoEstatus(int codigoEstatus) {
        this.codigoEstatus = codigoEstatus;
    }

    public String getUserAgent() {
        return userAgent;
    }

    public void setUserAgent(String userAgent) {
        this.userAgent = userAgent;
    }
    public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}
}
