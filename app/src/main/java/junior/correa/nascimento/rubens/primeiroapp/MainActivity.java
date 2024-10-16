package junior.correa.nascimento.rubens.primeiroapp;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
        Button btnEnviar = this.findViewById(R.id.btnEnviar); // Obtém o botão com o id btnEnviar por meio do findViewById que é uma função para obter elementos de uma View
        btnEnviar.setOnClickListener( // informa o objeto de onClickLinstener que será chamado
            new View.OnClickListener() { // cria um objeto de onClickListener que contém uma função onClick que será chamada ao clicar no botão que tenha o id especificado duas linhas atrás
                @Override
                public void onClick(View view) {
                    EditText et = findViewById(R.id.etText); // Obtém o elemento editText que tem o id 'etText'
                    String text = et.getText().toString(); // Obtém o texto da elemento obtido na linha anterior e atribui à variável 'text'
                    // setContentView(R.layout.activity_next); // Não é o melhor jeito de fazer, porque ele muda todo o contexto apagando todo o histórico

                    // Cria uma intenção de navegação da Activity Main para a Activity Next.
                    // 'MainActivity.this' e 'NextActivity.class': existe essa diferença pois o a Activity Main já está instanciada, já a Activity Next não
                    Intent i = new Intent(MainActivity.this, NextActivity.class);
                    // Insere na intent criada anteriormente um atributo 'text' com o valor que está na variável text
                    i.putExtra("text",text);
                    // Solicita ao sistema operacional que execute a intenção informada
                    startActivity(i);
                }
            }
        );
    }
}