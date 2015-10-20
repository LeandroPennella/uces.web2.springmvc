package ar.edu.uces.progweb2.springmvc.model;

import java.util.Date;

public class Pedido {
private long id;
private long cliente_id;
private Date fecha;
private Cliente cliente;
public Cliente getCliente() {
	return cliente;
}
public void setCliente(Cliente cliente) {
	this.cliente = cliente;
}
/*
public long getCliente_id() {
	return cliente_id;
}
public void setCliente_id(long cliente_id) {
	this.cliente_id = cliente_id;
}
*/
public Date getFecha() {
	return fecha;
}
public void setFecha(Date fecha) {
	this.fecha = fecha;
}


public void setId(long id) {
	this.id = id;
}
public long getId() {
	return id;
}
@Override
public int hashCode() {
	final int prime = 31;
	int result = 1;
	result = prime * result + (int) (cliente_id ^ (cliente_id >>> 32));
	result = prime * result + ((fecha == null) ? 0 : fecha.hashCode());
	return result;
}
@Override
public boolean equals(Object obj) {
	if (this == obj)
		return true;
	if (obj == null)
		return false;
	if (getClass() != obj.getClass())
		return false;
	Pedido other = (Pedido) obj;
	if (cliente_id != other.cliente_id)
		return false;
	if (fecha == null) {
		if (other.fecha != null)
			return false;
	} else if (!fecha.equals(other.fecha))
		return false;
	return true;
}



}
