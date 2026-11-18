package com.bytevortex.win10;

import android.app.Activity;
import android.os.Bundle;
import android.graphics.Color;
import android.view.Gravity;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Button;

public class MainActivity extends Activity {
    private int dp(float v) {
        return (int)(v * getResources().getDisplayMetrics().density + 0.5f);
    }

    @Override public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        LinearLayout page = new LinearLayout(this);
        page.setOrientation(LinearLayout.VERTICAL);
        page.setGravity(Gravity.CENTER);
        page.setPadding(dp(24), dp(24), dp(24), dp(24));
        page.setBackgroundColor(Color.rgb(5, 11, 24));

        TextView title = new TextView(this);
        title.setText("BYTE VORTEX PC");
        title.setTextColor(Color.rgb(0, 217, 255));
        title.setTextSize(28);
        title.setGravity(Gravity.CENTER);
        page.addView(title);

        TextView subtitle = new TextView(this);
        subtitle.setText("Windows 10 Pro • x86_64");
        subtitle.setTextColor(Color.WHITE);
        subtitle.setTextSize(17);
        subtitle.setGravity(Gravity.CENTER);
        LinearLayout.LayoutParams sp = new LinearLayout.LayoutParams(-1, -2);
        sp.topMargin = dp(12);
        page.addView(subtitle, sp);

        TextView status = new TextView(this);
        status.setText("Projeto-base instalado. O motor de virtualização QEMU para Android ainda precisa ser integrado e configurado. Este aplicativo, sozinho, ainda não inicializa o Windows.");
        status.setTextColor(Color.LTGRAY);
        status.setTextSize(15);
        status.setGravity(Gravity.CENTER);
        LinearLayout.LayoutParams tp = new LinearLayout.LayoutParams(-1, -2);
        tp.topMargin = dp(28);
        page.addView(status, tp);

        Button info = new Button(this);
        info.setText("Como preparar o Windows");
        info.setOnClickListener(v -> status.setText(
            "Próximos passos: integrar uma compilação confiável do QEMU para Android (arm64-v8a), implementar a tela/controles da VM e selecionar uma ISO/licença válida do Windows 10. A imagem do Windows não está incluída."
        ));
        LinearLayout.LayoutParams bp = new LinearLayout.LayoutParams(-1, -2);
        bp.topMargin = dp(24);
        page.addView(info, bp);

        setContentView(page);
    }
}
