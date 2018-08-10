package testeadapt3.cursoandroid2.com.passandodadosentreactivities;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import butterknife.BindView;

public class MainActivity extends SupportActivity {

    private static final int TELA_1_CONSTANTE = 1;
    private static final int TELA_2_CONSTANTE = 2;
    @BindView(R.id.editTextNomeMain)
    public EditText editTextNomeMain;

    @BindView(R.id.editTextEmailMain)
    public EditText editTextEmailMain;


    @Override
    int layoutID() {
        return R.layout.activity_main;
    }

    @Override
    void inicializar(Bundle savedInstanceState) {

    }

    public void mainEnviarTela1(View view) {
        //usamos a classe Bundle para iteragir com objeto(String) digitado
        Bundle bundle = new Bundle();
        bundle.putString( "nome", editTextNomeMain.getText().toString() );
        bundle.putString( "email", editTextEmailMain.getText().toString() );

        Intent intent = new Intent( this, Tela1Activity.class );
        intent.putExtras( bundle );
        startActivityForResult( intent, TELA_1_CONSTANTE );

    }

    public void mainEnviarTela2(View view) {
        Bundle bundle1 = new Bundle();
        bundle1.putString( "nome", editTextNomeMain.getText().toString() );
        bundle1.putString( "email", editTextEmailMain.getText().toString() );

        Intent intent = new Intent( this, Tela2Activity.class );
        intent.putExtras( bundle1 );
        startActivityForResult( intent, TELA_2_CONSTANTE );
    }

    //colher dados aceitos pela tela 1 e 2, ou recusados...utilizando o onActivityResult, conseguimos obter o resultado
    protected void onActivityResult(int qualTelaVeioResultado, int codigoResultado, Intent data) {

        if (qualTelaVeioResultado == TELA_1_CONSTANTE) {
            Bundle bundle = data.getExtras();
            if (bundle != null) {
                String aprendentarMsg = bundle.getString( "msg" );
                toastMessage( "tela 1 -> Resultado: " + codigoResultado + " | Msg: " + aprendentarMsg );
            }

        } else if (qualTelaVeioResultado == TELA_2_CONSTANTE) {
            Bundle bundle1 = data.getExtras();
            if (bundle1 != null) {
                String apresentarMsg = bundle1.getString( "result" );
                toastMessage( "tela 2 -> Resultado: " + codigoResultado + "| Msg: " + apresentarMsg );
            }
        }
    }

    private void toastMessage(String s) {
        Toast.makeText( getApplicationContext(), s, Toast.LENGTH_LONG ).show();
    }
}
