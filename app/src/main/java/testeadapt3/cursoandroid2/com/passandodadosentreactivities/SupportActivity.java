package testeadapt3.cursoandroid2.com.passandodadosentreactivities;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;

import butterknife.ButterKnife;

/**
 * Created by laianeoliveira on 10/08/18.
 */

public abstract class SupportActivity extends AppCompatActivity {

    /**
     * retorno o id do layoput
     * @return
     */
    abstract int layoutID();

    /**
     * Init substitui o onCreate
     *
     * @param savedInstanceState
     */

    abstract void inicializar(Bundle savedInstanceState);

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate( savedInstanceState );
        setContentView( layoutID() );
        ButterKnife.bind( this );

        this.inicializar( savedInstanceState );

    }
}
