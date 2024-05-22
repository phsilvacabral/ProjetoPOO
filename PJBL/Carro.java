package PJBL;

public class Carro extends Terrestre {
    private String tipoCarroceria;
    private int numAssentos;
    private int numPortas;
    private int capacidadePortaMala;
    private String motor;
    private int potenciaMotor;
    private String combustivel;
    private String cambio;

    public Carro(int codVeiculo, String tipo, String marca, String modelo, int ano, int quilometragem, String cor,
                 int capacidadeDePassageiro, double preco, int quantidade, int numRodas, String tipoCarroceria,
                 int numAssentos, int numPortas, int capacidadePortaMala, String motor, int potenciaMotor,
                 String combustivel, String cambio) {
        super(codVeiculo, tipo, marca, modelo, ano, quilometragem, cor, capacidadeDePassageiro, preco, quantidade,
                numRodas);
        this.tipoCarroceria = tipoCarroceria;
        this.numAssentos = numAssentos;
        this.numPortas = numPortas;
        this.capacidadePortaMala = capacidadePortaMala;
        this.motor = motor;
        this.potenciaMotor = potenciaMotor;
        this.combustivel = combustivel;
        this.cambio = cambio;
    }

    public String getTipoCarroceria() {
        return tipoCarroceria;
    }

    public void setTipoCarroceria(String tipoCarroceria) {
        this.tipoCarroceria = tipoCarroceria;
    }

    public int getNumAssentos() {
        return numAssentos;
    }

    public void setNumAssentos(int numAssentos) {
        this.numAssentos = numAssentos;
    }

    public int getNumPortas() {
        return numPortas;
    }

    public void setNumPortas(int numPortas) {
        this.numPortas = numPortas;
    }

    public int getCapacidadePortaMala() {
        return capacidadePortaMala;
    }

    public void setCapacidadePortaMala(int capacidadePortaMala) {
        this.capacidadePortaMala = capacidadePortaMala;
    }

    public String getMotor() {
        return motor;
    }

    public void setMotor(String motor) {
        this.motor = motor;
    }

    public int getPotenciaMotor() {
        return potenciaMotor;
    }

    public void setPotenciaMotor(int potenciaMotor) {
        this.potenciaMotor = potenciaMotor;
    }

    public String getCombustivel() {
        return combustivel;
    }

    public void setCombustivel(String combustivel) {
        this.combustivel = combustivel;
    }

    public String getCambio() {
        return cambio;
    }

    public void setCambio(String cambio) {
        this.cambio = cambio;
    }
}