public class Carro {
    String vin;
    String marca;
    String modelo;
    String color;
    int año;

    Carro(String vin, String marca,String color,String modelo,int año){
        this.vin = vin;
        this.marca = marca;
        this.modelo = modelo;
        this.color = color;
        this.año = año;
    }

    @Override
    public String toString() {
        return "*****\nVIN:"+this.vin+"\nMarca:"+this.marca+"\nModelo:"+this.modelo+"\nAño:"+this.año+"\nColor:"+this.color+"\n*****";
    }
}
