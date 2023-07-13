package xyz.sandersonsa.model;

public enum TabelasEnum {
    
        CANDIDATOS("dbhab.candidatos"),
        CANDIDATOS_COMISSAO("popular,candidato_comissao"),
        JULGAMENTO_PROCESSSO("dbhab.julgamento_processo"),
        DOCUMENTO_ANEXO("dbhab.documento_anexo"),
        CANDIDATO_RESTRICAO("dbhab.candidato_restricoes"),
        FILA_CODE("dbhab.fila_code_keys"),
        FILA_ACCESS("dbhab.fila_access_token"),
        FILA("dbhab.fila");
 
        private final String descricao;
 
        TabelasEnum(String descricao) {
            this.descricao = descricao;
        }

        public String getDescricao() {
            return this.descricao;
        }
    }