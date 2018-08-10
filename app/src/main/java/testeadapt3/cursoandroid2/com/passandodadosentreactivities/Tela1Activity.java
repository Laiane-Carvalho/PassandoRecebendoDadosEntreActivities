package testeadapt3.cursoandroid2.com.passandodadosentreactivities;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import butterknife.BindView;

public class Tela1Activity extends SupportActivity {

    @BindView(R.id.textNomeTela1)
    public TextView textNomeTela1;

    @BindView(R.id.textEmailTela1)
    public TextView textEmailTela1;

    @Override
    int layoutID() {
        return R.layout.activity_tela1;
    }

    @Override
    void inicializar(Bundle savedInstanceState) {

        //verificando e recebendo dados de uma intent
        Intent intent = getIntent();
        if (intent != null) {
            Bundle bundle = intent.getExtras();
            if (bundle != null) {
                String nomeRecuperado = bundle.getString( "nome" );
                String emailRecuperado = bundle.getString( "email" );

                textNomeTela1.setText( "nome: " + nomeRecuperado );
                textEmailTela1.setText( "email: " + emailRecuperado );
            }
        }
    }

    //metodos criados para manter os dandos passados, ou enviar para outra intente, trata-se de conversa entre intentes
    public void aceitarDados(View view) {

        Intent intent = new Intent();
        intent.putExtra( "msg", "Aceitou" );

        setResult( 1, intent );
        finish();
    }

    public void rejeitarDados(View view) {
        Intent intent = new Intent();
        intent.putExtra( "msg", "Recusou" );

        setResult( 2, intent );
        finish();
    }
}
