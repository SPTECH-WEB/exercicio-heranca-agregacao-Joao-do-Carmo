package school.sptech;

import java.util.ArrayList;
import java.util.List;
import  school.sptech.especialistas.DesenvolvedorWeb;
import  school.sptech.especialistas.DesenvolvedorMobile;

public class Consultoria {
    private String nome;
    private Integer vagas;
    private List<Desenvolvedor> desenvolvedores = new ArrayList<>();

    public Consultoria() {
    }

    public Integer getVagas() {
        return vagas;
    }

    public void setVagas(Integer vagas) {
        this.vagas = vagas;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public List<Desenvolvedor> getDesenvolvedores() {
        return desenvolvedores;
    }

    public void setDesenvolvedores(List<Desenvolvedor> desenvolvedores) {
        this.desenvolvedores = desenvolvedores;
    }

    public void contratar(Desenvolvedor desenvolvedor){
        if (desenvolvedores.size() < vagas){
            desenvolvedores.add(desenvolvedor);
        }
    }

    public void contratarFullstack(DesenvolvedorWeb desenvolvedor){
        if (desenvolvedor.isFullstack()){
            desenvolvedores.add(desenvolvedor);
        }
    }

    public Double getTotalSalarios(){
        Double soma = 0.0;
        for (Desenvolvedor desenvolvedores : desenvolvedores){
            soma += desenvolvedores.calcularSalario();
        }
        return soma;
    }

    public Integer qtdDesenvolvedoresMobile(){
        Integer soma = 0;
        for (Desenvolvedor desenvolvedores: desenvolvedores){
            if (desenvolvedores instanceof DesenvolvedorMobile){
                soma += 1;
            }
        }
        return soma;
    }

    public List<Desenvolvedor> buscarPorSalarioMaiorIgualQue(Double salario){
        List<Desenvolvedor> salarios = new ArrayList<>();
            for (Desenvolvedor desenvolvedores : desenvolvedores){
                if (desenvolvedores.calcularSalario() >= salario) {
                    salarios.add(desenvolvedores);
                }
            }
         return salarios;
    }

    public Desenvolvedor buscarMenorSalario(){
        if (desenvolvedores.isEmpty()){
            return null;
        }
        Desenvolvedor menorsalario = desenvolvedores.get(0);
        for (Desenvolvedor desenvolvedores : desenvolvedores){
            if (desenvolvedores.calcularSalario() < menorsalario.calcularSalario()){
                menorsalario = desenvolvedores;
            }
        }
        return menorsalario;
    }

    public List<Desenvolvedor> buscarPorTecnologia(String tecnologia){
        List<Desenvolvedor> temTecnologia = new ArrayList<>();
        for (Desenvolvedor desenvolvedores : desenvolvedores){
            if (desenvolvedores instanceof DesenvolvedorWeb){
                if (((DesenvolvedorWeb) desenvolvedores).getBackend().equals(tecnologia) || ((DesenvolvedorWeb) desenvolvedores).getFrontend().equals(tecnologia) || ((DesenvolvedorWeb) desenvolvedores).getSgbd().equals(tecnologia)){
                    temTecnologia.add(desenvolvedores);
                }
            }
            if (desenvolvedores instanceof DesenvolvedorMobile) {
                if (((DesenvolvedorMobile) desenvolvedores).getLinguagem().equals(tecnologia) || ((DesenvolvedorMobile) desenvolvedores).getPlataforma().equals(tecnologia)){
                    temTecnologia.add(desenvolvedores);
                }
            }
        }
        return temTecnologia;
    }

    public Double getTotalSalariosPorTecnologia(String tecnologia){
        Double salario = 0.0;
        for (Desenvolvedor desenvolvedores : desenvolvedores){
            if (desenvolvedores instanceof DesenvolvedorWeb){
                if (((DesenvolvedorWeb) desenvolvedores).getBackend().equals(tecnologia) || ((DesenvolvedorWeb) desenvolvedores).getFrontend().equals(tecnologia) || ((DesenvolvedorWeb) desenvolvedores).getSgbd().equals(tecnologia)){
                    salario += desenvolvedores.calcularSalario();
                }
            }
            if (desenvolvedores instanceof DesenvolvedorMobile) {
                if (((DesenvolvedorMobile) desenvolvedores).getLinguagem().equals(tecnologia) || ((DesenvolvedorMobile) desenvolvedores).getPlataforma().equals(tecnologia)){
                    salario += desenvolvedores.calcularSalario();
                }
            }
        }
        return salario;
    }
}
