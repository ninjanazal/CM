package a8794.clientes.ipca.testemodelo;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

public class ClientDetailsActivity extends AppCompatActivity {

    public static final String EXTRA_NAME = "extraName";
    public static final String EXTRA_NUM = "extraNum";
    public static final String EXTRA_EMAIL = "extraEmail";
    public static final String EXTRA_MOBILE = "extraMobile";

    TextView textViewNomeDetail, textViewNumDetail, textViewEmailDetail, textViewMobileDetail;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_client_details);
        setTitle(getIntent().getStringExtra(EXTRA_NAME));

        textViewNomeDetail = (TextView) findViewById(R.id.textViewDetailName);
        textViewNumDetail = (TextView) findViewById(R.id.textViewDetailNum);
        textViewEmailDetail = (TextView) findViewById(R.id.textViewDetailEmail);
        textViewMobileDetail = (TextView) findViewById(R.id.textViewDetailMobile);

        textViewNomeDetail.setText(getIntent().getStringExtra(EXTRA_NAME));
        textViewNumDetail.setText(getIntent().getStringExtra(EXTRA_NUM));
        textViewEmailDetail.setText(getIntent().getStringExtra(EXTRA_EMAIL));
        textViewMobileDetail.setText(getIntent().getStringExtra(EXTRA_MOBILE));
    }
}
