package br.ldkstudiosart.calculadora;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import net.objecthunter.exp4j.Expression;
import net.objecthunter.exp4j.ExpressionBuilder;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    private Button numberZero, numberUm, numberDois, numberTres, numberQuatro, numberCinco, numberSeis, numberSete, numberOito, numberNove, symPonto, symSoma,
                   symSubtracao, symMultiplicacao, symDivisao, igual, botaoLimpar;

    private TextView txtExpressao, txtResultado;

    private ImageView backspace;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        IniciarComponentes();

        numberZero.setOnClickListener(this);
        numberUm.setOnClickListener(this);
        numberDois.setOnClickListener(this);
        numberTres.setOnClickListener(this);
        numberQuatro.setOnClickListener(this);
        numberCinco.setOnClickListener(this);
        numberSeis.setOnClickListener(this);
        numberSete.setOnClickListener(this);
        numberOito.setOnClickListener(this);
        numberNove.setOnClickListener(this);
        symPonto.setOnClickListener(this);
        symSoma.setOnClickListener(this);
        symSubtracao.setOnClickListener(this);
        symMultiplicacao.setOnClickListener(this);
        symDivisao.setOnClickListener(this);

        botaoLimpar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                txtExpressao.setText("");
                txtResultado.setText("");
            }
        });

        backspace.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                TextView expressao = findViewById(R.id.txt_expressao);
                String string = expressao.getText().toString();

                if (!string.isEmpty()) {

                    byte var0 = 0;
                    int var1 = string.length() - 1;
                    String txtExpressao = string.substring(var0, var1);
                    expressao.setText(txtExpressao);
                }
                txtResultado.setText("");
            }
        });

        igual.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                try {
                    Expression expressao = new ExpressionBuilder(txtExpressao.getText().toString()).build();
                    double resultado = expressao.evaluate();
                    long longResult = (long) resultado;

                    if(resultado == (double)longResult) {
                        txtResultado.setText((CharSequence) String.valueOf(longResult));
                    } else {
                        txtResultado.setText((CharSequence) String.valueOf(resultado));
                    }
                }catch (Exception e) {

                }
            }
        });
    }

    private void IniciarComponentes() {
        numberZero = findViewById(R.id.numero_zero);
        numberUm = findViewById(R.id.numero_um);
        numberDois = findViewById(R.id.numero_dois);
        numberTres = findViewById(R.id.numero_tres);
        numberQuatro = findViewById(R.id.numero_quatro);
        numberCinco = findViewById(R.id.numero_cinco);
        numberSeis = findViewById(R.id.numero_seis);
        numberSete = findViewById(R.id.numero_sete);
        numberOito = findViewById(R.id.numero_oito);
        numberNove = findViewById(R.id.numero_nove);
        symPonto = findViewById(R.id.ponto);
        symSoma = findViewById(R.id.btn_soma);
        symSubtracao = findViewById(R.id.btn_subtracao);
        symMultiplicacao = findViewById(R.id.btn_multiplicacao);
        symDivisao = findViewById(R.id.btn_divisao);
        igual = findViewById(R.id.btn_igual);
        botaoLimpar = findViewById(R.id.btn_limpar);
        txtExpressao = findViewById(R.id.txt_expressao);
        txtResultado = findViewById(R.id.txt_resultado);
        backspace = findViewById(R.id.btn_backspace);
    }

    public void AdicionarExpressao(String string, boolean limpar_dados) {

        if(txtResultado.getText().equals("")) {
            txtExpressao.setText(" ");
        }

        if(limpar_dados) {
            txtResultado.setText(" ");
            txtExpressao.append(string);
        } else {
            txtExpressao.append(txtResultado.getText());
            txtExpressao.append(string);
            txtResultado.setText(" ");
        }
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.numero_zero:
                AdicionarExpressao("0", true);
                break;
            case R.id.numero_um:
                AdicionarExpressao("1", true);
                break;
            case R.id.numero_dois:
                AdicionarExpressao("2", true);
                break;
            case R.id.numero_tres:
                AdicionarExpressao("3", true);
                break;
            case R.id.numero_quatro:
                AdicionarExpressao("4", true);
                break;
            case R.id.numero_cinco:
                AdicionarExpressao("5", true);
                break;
            case R.id.numero_seis:
                AdicionarExpressao("6", true);
                break;
            case R.id.numero_sete:
                AdicionarExpressao("7", true);
                break;
            case R.id.numero_oito:
                AdicionarExpressao("8", true);
                break;
            case R.id.numero_nove:
                AdicionarExpressao("9", true);
                break;
            case R.id.ponto:
                AdicionarExpressao(".", true);
                break;
            case R.id.btn_soma:
                AdicionarExpressao("+", false);
                break;
            case R.id.btn_subtracao:
                AdicionarExpressao("-", false);
                break;
            case R.id.btn_multiplicacao:
                AdicionarExpressao("*", false);
                break;
            case R.id.btn_divisao:
                AdicionarExpressao("/", false);
                break;
        }
    }

    public void acessarHistory(View v) {
        Intent it = new Intent(getBaseContext(), HistoryActivity.class);
        it.putExtra("resultado", txtResultado.getText().toString());
        startActivity(it);
    }
}