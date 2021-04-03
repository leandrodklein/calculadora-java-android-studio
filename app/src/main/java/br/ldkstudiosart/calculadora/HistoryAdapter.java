package br.ldkstudiosart.calculadora;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import java.util.List;

public class HistoryAdapter extends BaseAdapter {
    LayoutInflater inflater;
    List<History> historys;

    public HistoryAdapter(List<History> historys, Context ctx) {
        this.historys = historys;
        inflater = LayoutInflater.from(ctx);
    }

    @Override
    public int getCount() {
        return historys.size();
    }

    @Override
    public Object getItem(int position) {
        return historys.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        View v = inflater.inflate(R.layout.history_item,null);
        TextView txtExpressao = v.findViewById(R.id.txtOperacaoItem);
        TextView txtResultado = v.findViewById(R.id.txtResultadoItem);

        History h = historys.get(position);
            txtExpressao.setText(h.getExpressao());
            txtResultado.setText(h.getResultado());
        return v;
    }
}
