package DAO;

import java.util.ArrayList;
import java.util.List;
import javax.swing.table.AbstractTableModel;

/**
 *
 * @author Jeam
 */
public class EntradaTableModel extends AbstractTableModel
{
     // Lista de Entradas a serem exibidos na tabela
    private List<Entrada> linhas;
    
    // Array com os nomes das colunas.
    private String[] colunas = new String[] { "Data", "Plano de Contas","Fontes de Renda","Descrição","Valor" };
    
    // Constantes representando o índice das colunas
    private static final int DATA        = 0;
    private static final int PLANOCONTAS = 1;
    private static final int FONTERENDA  = 2;
    private static final int DESCRICAO   = 3;
    private static final int VALOR       = 4;
 
    // Cria uma EntradaTableModel sem nenhuma linha
    public EntradaTableModel() {
        linhas = new ArrayList<Entrada>();
    }
 
    // Cria uma EntradaTableModel contendo a lista recebida por parâmetro
    public EntradaTableModel(List<Entrada> listaEntradas) {
        linhas = new ArrayList<Entrada>(listaEntradas);
    }
    
    
    @Override
    public int getRowCount()
    {
        return linhas.size();
    }

    @Override
    public int getColumnCount()
    {
        return colunas.length;
    }
    
    //array com os nomes das colunas para retornar o nome referente ao índice passado por parâmetro. 
    /*A vantagem de utilizar o array com os nomes das colunas é que se um dia acrescentarmos novas colunas à tabela,
     * não precisaremos modificar os métodos “getColumnCount” e “getColumnName”, bastará acrescentar o nome da nova coluna no array.
    */
    @Override
    public String getColumnName(int columnIndex)
    {
        return colunas[columnIndex];
    }
    
    @Override
    public Class<?> getColumnClass(int columnIndex) {
        switch (columnIndex) {
            case DATA:
                return String.class;
            case PLANOCONTAS:
                return String.class;
            case FONTERENDA:
                return String.class;
            case DESCRICAO:
                return String.class;
            case VALOR:
                return double.class;
            default:
                // Não deve ocorrer, pois só existem 5 colunas
                throw new IndexOutOfBoundsException("columnIndex out of bounds");
        }
    }
    
    @Override
    public boolean isCellEditable(int rowIndex, int columnIndex)
    {
        return false;
    }
   
    @Override
    public Object getValueAt(int rowIndex, int columnIndex)
    {
        // Pega a Entrada referente a linha especificada.
        Entrada ent = linhas.get(rowIndex);

        switch (columnIndex) {
            case DATA:
                return ent.getData();
            case PLANOCONTAS:
                return ent.categoria.getNome();
            case FONTERENDA:
                return ent.fonte.getNome();
            case DESCRICAO:
                return ent.getDescricao();
            case VALOR:
                return ent.getValor();
            default:
                // Não deve ocorrer, pois só existem 2 colunas
                throw new IndexOutOfBoundsException("columnIndex out of bounds");
        }
    }
    
  /*  @Override
    public void setValueAt(Object aValue, int rowIndex, int columnIndex)
    {
        // Pega a entrada referente a linha especificada.
        Entrada ent = linhas.get(rowIndex);

        switch (columnIndex) {
             case DATA:
                return ent.s;
            case PLANOCONTAS:
                ent.categoria.setNome((String) aValue);
            case FONTERENDA:
                 ent.fonte.setNome((String) aValue);
            case DESCRICAO:
                 ent.setDescricao((String) aValue);
            case VALOR:
                ent.setValor((String) aValue);
                break;
            default:
                // Não deve ocorrer, pois só existem 2 colunas
                throw new IndexOutOfBoundsException("columnIndex out of bounds");
        }

        fireTableCellUpdated(rowIndex, columnIndex); // Notifica a atualização da célula
    }*/
    // Retorna o sócio referente a linha especificada
    public Entrada getEntrada(int indiceLinha) {
        return linhas.get(indiceLinha);
    }

// Adiciona o sócio especificado ao modelo
    public void addEntrada(Entrada ent) {
        // Adiciona o registro.
        linhas.add(ent);

        // Pega a quantidade de registros e subtrai 1 para
        // achar o último índice. A subtração é necessária
        // porque os índices começam em zero.
        int ultimoIndice = getRowCount() - 1;

        // Notifica a mudança.
        fireTableRowsInserted(ultimoIndice, ultimoIndice);
    }

// Remove o sócio da linha especificada.
    public void removeEntrada(int indiceLinha) {
        // Remove o registro.
        linhas.remove(indiceLinha);

        // Notifica a mudança.
        fireTableRowsDeleted(indiceLinha, indiceLinha);
    }

// Adiciona uma lista de sócios no final da lista.
    public void addListaEntradas(List<Entrada> ent) {
        // Pega o tamanho antigo da tabela, que servirá
        // como índice para o primeiro dos novos registros
        int indice = getRowCount();

        // Adiciona os registros.
        linhas.addAll(ent);

        // Notifica a mudança.
        fireTableRowsInserted(indice, indice + ent.size());
    }

// Remove todos os registros.
    public void limpar() {
        // Remove todos os elementos da lista de sócios.
        linhas.clear();

        // Notifica a mudança.
        fireTableDataChanged();
    }
}
