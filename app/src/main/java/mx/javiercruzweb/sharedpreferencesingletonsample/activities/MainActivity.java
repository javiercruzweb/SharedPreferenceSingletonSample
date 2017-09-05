package mx.javiercruzweb.sharedpreferencesingletonsample.activities;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.CompoundButton;
import android.widget.SeekBar;
import android.widget.Switch;

import butterknife.BindView;
import butterknife.ButterKnife;
import mx.javiercruzweb.sharedpreferencesingletonsample.R;
import mx.javiercruzweb.sharedpreferencesingletonsample.utils.GlobalSettings;

public class MainActivity extends AppCompatActivity {

    public static final String TAG = MainActivity.class.getSimpleName();

    @BindView(R.id.switchGlobalSettingsSound)
    public Switch switchGlobalSettingsSound;
    @BindView(R.id.switchglobalSettingsNotifications)
    public Switch switchglobalSettingsNotifications;
    @BindView(R.id.seekBarGlobalSettingsRadio)
    public SeekBar seekBarGlobalSettingsRadio;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);
        setUI();
        setViewListeners();
    }

    private void setUI(){
        Boolean globalSettingsSound = GlobalSettings.getInstance()
                .getBoolean(GlobalSettings.Key.GLOBAL_SETTINGS_SOUND);
        Log.d(TAG, "globalSettingsSound: " + globalSettingsSound);
        Boolean globalSettingsNotifications = GlobalSettings.getInstance()
                .getBoolean(GlobalSettings.Key.GLOBAL_SETTINGS_NOTIFICATIONS);
        Log.d(TAG, "globalSettingsNotifications: " + globalSettingsNotifications);
        Integer   globalSettingsRadio = GlobalSettings.getInstance()
                .getInt(GlobalSettings.Key.GLOBAL_SETTINGS_RADIO);
        Log.d(TAG, "globalSettingsRadio: " + globalSettingsRadio);

        switchGlobalSettingsSound.setChecked(globalSettingsSound);
        switchglobalSettingsNotifications.setChecked(globalSettingsNotifications);
        seekBarGlobalSettingsRadio.setMax(100);
        seekBarGlobalSettingsRadio.setProgress(globalSettingsRadio);

    }

    private void setViewListeners(){

        switchGlobalSettingsSound.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                GlobalSettings.getInstance()
                        .put(GlobalSettings.Key.GLOBAL_SETTINGS_SOUND, isChecked);
            }
        });

        switchglobalSettingsNotifications.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                GlobalSettings.getInstance()
                        .put(GlobalSettings.Key.GLOBAL_SETTINGS_NOTIFICATIONS, isChecked);
            }
        });

        seekBarGlobalSettingsRadio.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {
                // TODO Auto-generated method stub
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {
                // TODO Auto-generated method stub
            }

            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                // TODO Auto-generated method stub
                GlobalSettings.getInstance()
                        .put(GlobalSettings.Key.GLOBAL_SETTINGS_RADIO, progress);

            }
        });

    }
}
