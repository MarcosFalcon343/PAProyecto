import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import PuntoVenta.VTicket;
import Clases.Producto;
import Clases.Ticket;
import Clases.Venta;
import Libreria.Libreria;
import Listas.LProductos;
import Listas.LVenta;
import Genericos.genericos;
import Inventario.controlarInv;

public class puntoVenta implements ActionListener{

	private static LVenta venta;
	public static  VTicket Vticket;
	private static Ticket ticket;
	private static LProductos listado = new LProductos("productos.txt");
	
	public puntoVenta() {
		venta = new LVenta("ventas.txt");
		this.ticket = new Ticket(Libreria.idFormat(venta.sigID()),Libreria.Fecha());
		Vticket = new VTicket(ticket.getIdTicket(),ticket.getFecha());
		this.mostrarProductos();
		this.mostrarTotales();
		this.Vticket.setVisible(true);
		
		//Actionlistener
		this.Vticket.editar.BAB.BtnAlta.addActionListener(this);
		this.Vticket.editar.BAB.BtnBaja.addActionListener(this);
		this.Vticket.editar.BAB.BtnBuscar.addActionListener(this);
		this.Vticket.editar.ICP.BtnInventario.addActionListener(this);
		this.Vticket.editar.ICP.BtnCancelar.addActionListener(this);
		this.Vticket.editar.ICP.BtnPagar.addActionListener(this);
	}
	
	public void alta() {
		String id;
		Producto producto = null;
		try {
			if(this.Vticket.editar.entradas.nombre.getText().length() != 0) {
				id = this.Vticket.editar.entradas.id.getText();
				producto = this.obtener(id);
				if(producto != null) {
					ticket.insertar(producto);
					this.Vticket.editar.entradas.nombre.setText("");
					this.Vticket.editar.entradas.precio.setText("");
				}
				this.mostrar();
			}else genericos.advertencia("NO SE HA BUSCADO EL PRODUCTO");
		}catch(Exception e) {
			System.out.println("ERROR. LLAMA A SOPORTE TECNICO " +e.getMessage());
		}
	}
	
	public void baja() {
		String id;
		try {
			if(this.Vticket.editar.entradas.nombre.getText().length() != 0) {
				if(ticket.size() > 0) {
					id = this.Vticket.editar.entradas.id.getText();
					ticket.remover(id);
					
					this.Vticket.editar.entradas.nombre.setText("");
					this.Vticket.editar.entradas.precio.setText("");
				}else genericos.advertencia("NO HAY NINGUN PRODUCTO, AGREGUE UNO");
				this.mostrar();
			}else genericos.advertencia("NO SE HA BUSCADO EL PRODUCTO");
		}catch(Exception e) {
			Genericos.genericos.error("ERROR. LLAMA A SOPORTE TECNICO " +e.getMessage());
		}
	}
	
	public  void buscar() {
		String id;
		Producto producto = null;
		try {
			if(this.Vticket.editar.entradas.id.getText().length() != 0) {
				id = this.Vticket.editar.entradas.id.getText();
				producto = this.obtener(id);
				if(producto != null) {
					this.Vticket.editar.entradas.nombre.setText(producto.getNombre());
					this.Vticket.editar.entradas.precio.setText(producto.getPrecio());
				}else {
					genericos.advertencia("ESTE PRODUCTO NO EXISTE EN EL INVENTARIO :)");
				}
			}else genericos.advertencia("INGRESE EL ID DEL PRODUCTO A BUSCAR\nSI NO LO CONOCE PRESIONE EL BOTON DE DEBAJO");
		}catch(Exception e) {
			
		}
	}
	
	public void cancelar() {
		this.Vticket.dispose();
	}
	
	public void pagar() {
		ArrayList<Producto> productos = ticket.getProductos();
		try {
			if(productos.size() >0) {
				for(Producto nodo: productos) {
					venta.insertar(new Venta(ticket.getFecha(),ticket.getIdTicket(),nodo.getIdProducto(),nodo.getPrecio(),nodo.getCantidad()));
				}
				genericos.hecho("COMPRA REALIZADA CORRECTAMENTE");
				this.Vticket.dispose();
			}else {
				genericos.advertencia("CANCELANDO COMPRA");
				this.cancelar();
			}
		}catch(Exception e) {
			genericos.error("ERROR. LLAMA A SOPORTE TECNICO " +e.getMessage());
			//System.out.println("ERROR. LLAMA A SOPORTE TECNICO " +e.getMessage());
		}
	}
	
	public void inventario() {
		controlarInv inv = new controlarInv();
	}

	public void mostrar() {
		this.mostrarProductos();
		this.mostrarTotales();
	}
	
	public void mostrarProductos() {
		this.Vticket.vista.lista.Lista.setText("");
		this.Vticket.vista.lista.agregarProducto(this.ticket.mostrarProductos());
	}
	
	public void mostrarTotales() {
		this.Vticket.vista.totals.si.subtotal.setText(this.ticket.subtotal());
		this.Vticket.vista.totals.si.iva.setText(this.ticket.IVA());
		this.Vticket.vista.totals.total.total.setText(this.ticket.total());
	}
	
	
	private Producto obtener(String id) {
		return listado.obtener(id);
	}
	

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		if(e.getSource() == this.Vticket.editar.BAB.BtnAlta) this.alta();
		else if(e.getSource() == this.Vticket.editar.BAB.BtnBaja) this.baja();
		else if(e.getSource() == this.Vticket.editar.BAB.BtnBuscar) this.buscar();
		else if(e.getSource() == this.Vticket.editar.ICP.BtnInventario) this.inventario();
		else if(e.getSource() == this.Vticket.editar.ICP.BtnCancelar) this.cancelar();
		else if(e.getSource() == this.Vticket.editar.ICP.BtnPagar) this.pagar();
	}

}
