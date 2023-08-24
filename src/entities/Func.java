package entities;

public class Func {
	
	private Integer id;
	private String nome;
	private Double salario;
	
	public Func() {}
	
	
	public Func(Integer id, String nome, Double salario) {
		this.id = id;
		this.nome = nome;
		this.salario = salario;
	}
	

	public Integer getId() {
		return id;
	}
	
	
	public void aumentoSalario(double porcentagem) {
		salario += salario * porcentagem / 100;
	}


	@Override
	public String toString() {
		return id +", " + nome +", "  + String.format("%.2f", salario) ;
	}
	
	
	
	
	
}
