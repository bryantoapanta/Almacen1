package almacen1;

/*
 * Implementar un almacén de enteros mediante una tabla de huecos
 * se supone que no puede contener el valor 0 ya que indica posiciones libre.
 */
public class Almacen1 {

	static private final int LIBRE = 0;
	// Array con los valores almacenados
	private int tvalores[];
	private int valoresAlmacenados = 0;
	
	// Constructores sin parámetros creo una tabla de 10 elementos 
	public Almacen1(){
		this(10);  // Llamo al constructor con parámetros
	}

	// Constructor donde se fija tamaño máximo del Almacén
	public Almacen1( int tamaño){
		tvalores = new int [tamaño];
		init();
	}
	
	// Pone todas las posiciones a LIBRES
	public void init (){
		for (int i = 0; i < tvalores.length; i++) {
			tvalores[i] = Almacen1.LIBRE;
		}
		valoresAlmacenados = 0;
	}
	
	// Muestra una cadena con los valores de la tabla
	public String toString (){
		String tabla= "";
				//tvalores.toString();//convierto la tabla en String
		for(int x=0; x<tvalores.length;x++) {
			tabla+=tvalores[x]+" ";}
			
		return tabla;
	}
	
	// Devuelve el números de posiciones libres
	public int numPosicionesLibres(){
		int libres=0;
		for(int x=0; x<this.tvalores.length;x++) {
			if(this.tvalores[x]==0) {
				libres++;
			}
		}
		return libres;
	}
	
	// Devuelve el número de posiones ocupadas
	public int numPosicionesOcupadas(){
		int ocupadas=0;
		for(int x=0; x<this.tvalores.length;x++) {
			if(this.tvalores[x]!=0) {
				ocupadas++;
			}
		}
		return ocupadas;
	}
	
	// Devuelve verdadero o falso si está almacenado el valor en la tabla
	public boolean estaValor ( int num){
		boolean yaEsta=false;
		for(int x=0; x<this.tvalores.length;x++) {
			if(this.tvalores[x]==num) {
				yaEsta=true;
			}
		}
	return yaEsta;
	}
	
	// Almacena el valor en la tabla, devuelve false sin no puede almacenarlo
	public boolean ponValor (int num){
		boolean almacenado=false;
		if(this.estaLleno()==false) {//si no esta lleno continua
			
		
				if(this.estaValor(num)==false){//si el valor no esta repetido
					
					for(int x=0; x<this.tvalores.length;x++) {
						
						if(this.tvalores[x]==0) {// si esta libre 
							this.tvalores[x]=num;
							almacenado=true;System.out.println("numero almacenado= "+tvalores[x]);
							break;
					
				}
						else {almacenado=false;}
			}
		}
				else {almacenado=false;}
				}
		else {almacenado=false;}
		
	return almacenado;
	}
	
	// Elimina el elemento de la tabla, si no esta devuelve false
	public boolean sacarValor (int num){	
		boolean eliminado=false;
		
		for(int x=0; x<this.tvalores.length;x++) {
			if(this.tvalores[x]==num) {// si el numero coincide
				this.tvalores[x]=Almacen1.LIBRE;// el numero =0
				eliminado=true;
				break;}
			
			else {eliminado=false;}
		}
	return eliminado;
	}
      // Indica si el almacén esta lleno
	public boolean estaLleno (){
		
		if(numPosicionesOcupadas()==this.tvalores.length) {//  si posiciones ocupadas = a la longitud entoces tas lleno
			return true;
		}
		else {return false;}

	}
}