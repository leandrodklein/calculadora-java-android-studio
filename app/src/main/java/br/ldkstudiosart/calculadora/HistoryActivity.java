package br.ldkstudiosart.calculadora;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

public class HistoryActivity extends AppCompatActivity {

    EditText txtExpressao;
    EditText txtResultado;
    Button btnIgual;
    ListView listHistory;
    List<History> historys = new ArrayList<>();
    HistoryAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_history);

        Intent it = getIntent();
        String resultado = it.getStringExtra("resultado");
        TextView txtSaidaDev = findViewById(R.id.txtSaidaDev);
        txtSaidaDev.setText(resultado);

        txtExpressao = findViewById(R.id.txt_expressao);
        txtResultado = findViewById(R.id.txt_resultado);
        btnIgual = findViewById(R.id.btn_igual);
        View.OnClickListener btClickLisnter;
        //btnIgual.setOnClickListener(btClickLisnter);
        listHistory = findViewById(R.id.listHistory);
        adapter = new HistoryAdapter(historys, getBaseContext());
        listHistory.setAdapter(adapter);
    }

    public void processarCliqueAdicionar(View v) {
        History h = new History();
        h.setExpressao(txtExpressao.getText().toString());
        h.setResultado(txtResultado.getText().toString());

        historys.add(h);
        adapter.notifyDataSetChanged();

    }


    public void voltar(View v) {
        finish();
    }
}