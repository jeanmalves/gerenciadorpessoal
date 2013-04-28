    package logica;

// Importa as bibilotecas Java necessárias
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.math.BigDecimal;
import java.math.BigInteger;
import java.text.DecimalFormat;
import java.text.NumberFormat;

import javax.swing.JFrame;
import javax.swing.JTextField;
import javax.swing.event.CaretEvent;
import javax.swing.event.CaretListener;
import javax.swing.text.AttributeSet;
import javax.swing.text.BadLocationException;
import javax.swing.text.PlainDocument;

/**
 * Campo para a inserção de números com base em um formato.
 * 
 * @author Dyorgio da Silva Nascimento
 */
public class JNumberFormatField extends JTextField {

  private static final long serialVersionUID = -7506506392528621022L;

  private static final NumberFormat MONETARY_FORMAT = new DecimalFormat("#,##0.00");

  private NumberFormat numberFormat;

  private int limit = -1;

  public JNumberFormatField(int casasDecimais) {
    this(new DecimalFormat((casasDecimais == 0 ? "#,##0" : "#,##0.") + makeZeros(casasDecimais)));
  }

  public JNumberFormatField() {
    this(MONETARY_FORMAT);
  }

  public JNumberFormatField(NumberFormat format) {
    // define o formato do número
    numberFormat = format;
    // alinhamento horizontal para o texto
    setHorizontalAlignment(RIGHT);
    // documento responsável pela formatação do campo
    setDocument(new PlainDocument() {

      private static final long serialVersionUID = 1L;

      @Override
      public void insertString(int offs, String str, AttributeSet a) throws BadLocationException {
        String text = new StringBuilder(JNumberFormatField.this.getText().replaceAll("[^0-9]", "")).append(
            str.replaceAll("[^0-9]", "")).toString();
        super.remove(0, getLength());
        if (text.isEmpty()) {
          text = "0";
        }else{
          text = new BigInteger(text).toString();
        }

        super.insertString(0, numberFormat.format(new BigDecimal(getLimit() > 0 && text.length() > getLimit() ? text
            .substring(0, getLimit()) : text).divide(new BigDecimal(Math.pow(10, numberFormat
            .getMaximumFractionDigits())))), a);
      }

      @Override
      public void remove(int offs, int len) throws BadLocationException {
        super.remove(offs, len);
        if (len != getLength()) {
          insertString(0, "", null);
        }
      }
    });
    // mantem o cursor no final do campo
    addCaretListener(new CaretListener() {

      boolean update = false;

      @Override
      public void caretUpdate(CaretEvent e) {
        if (!update) {
          update = true;
          setCaretPosition(getText().length());
          update = false;
        }
      }
    });
    // limpa o campo se apertar DELETE
    addKeyListener(new KeyAdapter() {

      @Override
      public void keyPressed(KeyEvent e) {
        if (e.getKeyCode() == KeyEvent.VK_DELETE) {
          setText("");
        }
      }
    });
    // formato inicial
    setText("0");
    setCaretPosition(getText().length());
  }

  /**
   * Define um valor BigDecimal ao campo
   * 
   * @param value
   */
  public void setValue(BigDecimal value) {
    super.setText(numberFormat.format(value));
  }

  /**
   * Recupera um valor BigDecimal do campo
   * 
   * @return
   */
  public final BigDecimal getValue() {
    return new BigDecimal(getText().replaceAll("[^0-9]", "")).divide(new BigDecimal(Math.pow(10, numberFormat
        .getMaximumFractionDigits())));
  }

  /**
   * Recupera o formatador atual do campo
   * 
   * @return
   */
  public NumberFormat getNumberFormat() {
    return numberFormat;
  }

  /**
   * Define o formatador do campo
   * 
   * @param numberFormat
   */
  public void setNumberFormat(NumberFormat numberFormat) {
    this.numberFormat = numberFormat;
  }

  /**
   * Preenche um StringBuilder com zeros
   * 
   * @param zeros
   * @return
   */
  private static final String makeZeros(int zeros) {
    if (zeros >= 0) {
      StringBuilder builder = new StringBuilder();

      for (int i = 0; i < zeros; i++) {
        builder.append('0');
      }
      return builder.toString();
    } else {
      throw new RuntimeException("Número de casas decimais inválida (" + zeros + ")");
    }
  }

  /**
   * Recupera o limite do campo.
   * 
   * @return
   */
  public int getLimit() {
    return limit;
  }

  /**
   * Define o limite do campo, limit < 0 para deixar livre (default) Ignora os pontos e virgulas do formato, conta
   * somente com os números
   * 
   * @param limit
   */
  public void setLimit(int limit) {
    this.limit = limit;
  }

  // testes, pode ser removido
 /* public static void main(String[] args) {
    JFrame frame = new JFrame("Teste do campo");
    frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
    frame.setResizable(false);
    frame.add(new JNumberFormatField(new DecimalFormat("0.000")) {

      {
        // limita a 4 caracteres
        setLimit(4);
      }
    });
    frame.pack();
    frame.setLocationRelativeTo(null);
    frame.setVisible(true);
  }*/
}




/*
    import java.awt.event.FocusAdapter;  
    import java.awt.event.FocusEvent;  
      
    import javax.swing.JFormattedTextField;  
    import javax.swing.JTextField;  
    import javax.swing.event.CaretEvent;  
    import javax.swing.event.CaretListener;  
    import javax.swing.text.AttributeSet;  
    import javax.swing.text.BadLocationException;  
    import javax.swing.text.PlainDocument;  
    import javax.swing.text.SimpleAttributeSet;  
      
    /** 
    * Component JMoneyField 
    * @author Dyorgio da Silva Nascimento 
    */  
/*    public class JMoneyField extends JFormattedTextField {  
          
        private static final long serialVersionUID = -5712106034509737967L;  
        private static final SimpleAttributeSet nullAttribute = new SimpleAttributeSet();  
          
        /** 
         * Creates a new instance of JMoneyField 
         */  
 /*       public JMoneyField() {  
            this.setHorizontalAlignment( JTextField.CENTER );  
            this.setDocument(new MoneyFieldDocument());  
            this.addFocusListener(new MoneyFieldFocusListener());  
            this.setText("0,00");  
            this.addCaretListener(new CaretListener(){  
                public void caretUpdate(CaretEvent e) {  
                    if (e.getDot() != getText().length() ) {  
                        getCaret().setDot(getText().length());  
                    }  
                }  
            });  
        }  
          
        private final class MoneyFieldFocusListener extends FocusAdapter{  
            public void focusGained(FocusEvent e) {  
                selectAll();  
            }  
        }  
          
        private final class MoneyFieldDocument extends PlainDocument {  
              
            /** 
             *  
             */  
/*            private static final long serialVersionUID = -3802846632709128803L;  
      
            public void insertString(int offs, String str, AttributeSet a) throws BadLocationException {  
                String original = getText(0,getLength());  
                  
                // Permite apenas digitar até 16 caracteres (9.999.999.999,99)  
                if (original.length()<16) {  
                    StringBuffer mascarado = new StringBuffer();  
                    if (a != nullAttribute) {  
                        //limpa o campo  
                        remove(-1,getLength());  
                          
                        mascarado.append((original+str).replaceAll("[^0-9]",""));  
                        for (int i = 0; i < mascarado.length(); i++){  
                            if (!Character.isDigit(mascarado.charAt(i))){  
                                mascarado.deleteCharAt(i);  
                            }  
                        }  
                        Long number = new Long(mascarado.toString());  
                          
                        mascarado.replace(0, mascarado.length(), number.toString());  
                          
                        if ( mascarado.length() < 3 )  
                        {  
                            if ( mascarado.length() == 1 ) {  
                                mascarado.insert(0,"0");  
                                mascarado.insert(0,",");  
                                mascarado.insert(0,"0");  
                            }else if ( mascarado.length() == 2 ) {  
                                mascarado.insert(0,",");  
                                mascarado.insert(0,"0");  
                            }  
                        }else{  
                            mascarado.insert(mascarado.length()-2,",");  
                        }  
                          
                        if ( mascarado.length() > 6 ) {  
                            mascarado.insert(mascarado.length()-6, '.');  
                            if (mascarado.length() > 10 ) {  
                                mascarado.insert(mascarado.length()-10, '.');  
                                if (mascarado.length() > 14 ) {  
                                    mascarado.insert(mascarado.length()-14, '.');  
                                }  
                            }  
                        }  
                        super.insertString(0, mascarado.toString(), a);  
                    }else{  
                        if (original.length() == 0){  
                            super.insertString(0, "0,00", a);  
                        }  
                    }  
                }  
            }  
              
            @Override  
            public void remove(int offs, int len) throws BadLocationException {  
                if ( len == getLength() ) {  
                    super.remove(0, len);  
                    if (offs != -1){  
                        insertString(0, "",nullAttribute);  
                    }  
                }else{  
                    String original = getText(0, getLength()).substring(0, offs) + getText(0, getLength()).substring(offs+len);  
                    super.remove(0, getLength());  
                    insertString(0,original,null);  
                }  
            }  
        }  
    }  */