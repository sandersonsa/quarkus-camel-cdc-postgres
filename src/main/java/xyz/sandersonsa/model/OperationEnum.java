package xyz.sandersonsa.model;

public enum OperationEnum {

    // c= create, u= update, d= delete, r= snapshot
    INSERT("c"),
    UPDATE("u"),
    DELETE("d");
 
    private final String descricao;

    OperationEnum(String descricao) {
        this.descricao = descricao;
    }

    public String getDescricao() {
        return this.descricao;
    }
}