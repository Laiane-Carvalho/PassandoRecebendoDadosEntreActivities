package testeadapt3.cursoandroid2.com.passandodadosentreactivities;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import butterknife.BindView;

public class Tela2Activity extends SupportActivity {

    @BindView(R.id.textNomeTela2)
    public TextView textNomeTela2;

    @BindView(R.id.textEmailTela2)
    public TextView textEmailTela2;

    @Override
    int layoutID() {
        return R.layout.activity_tela2;
    }

    @Override
    void inicializar(Bundle savedInstanceState) {

        Intent intent = getIntent();
        if (intent != null) {
            Bundle bundle = intent.getExtras();
            if (bundle != null) {
                String nomeRecuperado = bundle.getString( "nome" );
                String emailRecuperado = bundle.getString( "email" );

                textNomeTela2.setText( "nome: " +nomeRecuperado);
                textEmailTela2.setText( "email: " +emailRecuperado);
            }
        }
    }

    public void aceitarDados(View view) {
        Intent intent = new Intent(  );
        intent.putExtra( "result","Aceitou" );

        setResult(2, intent );
        finish();
    }

    public void rejeitarDados(View view) {
        Intent intent = new Intent(  );
        intent.putExtra( "result","Rejeitou" );

        setResult( 3,intent );
        finish();
    }
}
