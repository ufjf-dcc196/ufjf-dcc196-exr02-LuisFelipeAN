package br.ufjf.dcc196.dcc196exemplo02;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    private EditText numero1;
    private EditText numero2;
    private Button divisao;
    private Button multiplicacao;
    private Button mais;
    private Button menos;
    private TextView resultado;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //1 - encontre os componentes de entrada
        numero1 = (EditText) findViewById(R.id.numero1);
        numero2 = (EditText) findViewById(R.id.numero2);

        //2 - procure os componetes de saida
        resultado = (TextView) findViewById(R.id.resultado);

        //3 - procure os componentes de controle
        divisao = (Button) findViewById(R.id.div);
        mais = (Button) findViewById(R.id.mais);
        menos = (Button) findViewById(R.id.menos);
        multiplicacao = (Button) findViewById(R.id.mult);
        //4 - configurar os ouvintes para eventos
        OuvinteDivisao ouvinte1 = new OuvinteDivisao();
        divisao.setOnClickListener(ouvinte1);

        OuvinteSoma ouvinte2 = new OuvinteSoma();
        mais.setOnClickListener(ouvinte2);

        OuvinteSubtracao ouvinte3 = new OuvinteSubtracao();
        menos.setOnClickListener(ouvinte3);

        OuvinteMultiplicacao ouvinte4 = new OuvinteMultiplicacao();
        multiplicacao.setOnClickListener(ouvinte4);

    }


    private class Ouvinte implements View.OnClickListener {

        @Override
        public void onClick(View view) {
            float n1 = Float.parseFloat(numero1.getText().toString());
            float n2 = Float.parseFloat(numero2.getText().toString());


            resultado.setText("Resultado é: "+operacao(n1,n2));
        }
        float operacao(float n1 , float n2){
           return 0;
        }
    }
    private class OuvinteDivisao extends Ouvinte{
        @Override
        float operacao(float n1 , float n2){
            return n1/n2;
        }
    }
    private class OuvinteSoma extends Ouvinte{
        @Override
        float operacao(float n1 , float n2){
            return n1+n2;
        }
    }
    private class OuvinteMultiplicacao extends Ouvinte{
        @Override
        float operacao(float n1 , float n2){
            return n1*n2;
        }
    }
    private class OuvinteSubtracao extends Ouvinte{
        @Override
        float operacao(float n1 , float n2){
            return n1-n2;
        }
    }
}
