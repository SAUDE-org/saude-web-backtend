package com.elildes.saude_backend.entity;

public class Profissional extends Pessoa {
    
    private String registro_pro;

    public Profissional(){};

    public Profissional(String registro_pro) {
        this.registro_pro = registro_pro;
    }

    public String getRegistro_pro() {
        return registro_pro;
    }

    public void setRegistro_pro(String registro_pro) {
        this.registro_pro = registro_pro;
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = super.hashCode();
        result = prime * result + ((registro_pro == null) ? 0 : registro_pro.hashCode());
        return result;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (!super.equals(obj))
            return false;
        if (getClass() != obj.getClass())
            return false;
        Profissional other = (Profissional) obj;
        if (registro_pro == null) {
            if (other.registro_pro != null)
                return false;
        } else if (!registro_pro.equals(other.registro_pro))
            return false;
        return true;
    }

    @Override
    public String toString() {
        return "Profissional [registro_pro=" + registro_pro + ", getRegistro_pro()=" + getRegistro_pro()
                + ", getId_pessoa()=" + getId_pessoa() + ", getNome()=" + getNome() + ", hashCode()=" + hashCode()
                + ", getCpf()=" + getCpf() + ", getEmail()=" + getEmail() + ", getTelefone()=" + getTelefone()
                + ", getEndereco()=" + getEndereco() + ", getClass()=" + getClass() + ", toString()=" + super.toString()
                + "]";
    }

}
