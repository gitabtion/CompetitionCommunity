package cn.abtion.neuqercc.mine.activities;

import android.app.Dialog;
import android.os.Bundle;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.ImageView;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import cn.abtion.neuqercc.R;
import cn.abtion.neuqercc.base.activities.NoBarActivity;
import cn.abtion.neuqercc.utils.ToastUtil;

/**
 * @author fhyPayaso
 * @since 2017/11/15 21:30
 * email fhyPayaso@qq.com
 */

public class UpdateInformationActivity extends NoBarActivity {

    public static final int FLAG_EYE_OPEN=1;
    public static final int FLAG_EYE_CLOSE=0;

    public static int flagNameEye = 1;
    public static int flagPhoneEye = 1;
    public Dialog dialogAddHonor;
    Button btnAddHonor;
    Button btnCancel;

    @BindView(R.id.img_mine_name_eye)
    ImageView imgNameEye;
    @BindView(R.id.img_mine_phone_eye)
    ImageView imgPhoneEye;
    @BindView(R.id.img_mine_update_honor)
    ImageView imgUpdateHonor;
    @BindView(R.id.cb_edit_girl)
    CheckBox checkBoxGirl;
    @BindView(R.id.cb_edit_boy)
    CheckBox checkBoxBoy;


    @Override
    protected int getLayoutId() {
        return R.layout.activity_update_imformation;
    }

    @Override
    protected void initVariable() {

    }

    @Override
    protected void initView() {

        initCheckbox();

    }

    @Override
    protected void loadData() {

    }


    /**
     * 初始化CheckBox
     */
    public void initCheckbox() {

        checkBoxGirl.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (isChecked && checkBoxBoy.isChecked()) {
                    checkBoxBoy.setChecked(false);
                }
            }
        });

        checkBoxBoy.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {

                if (isChecked && checkBoxGirl.isChecked()) {
                    checkBoxGirl.setChecked(false);
                }
            }
        });

    }


    @OnClick(R.id.img_mine_name_eye)
    public void onImgNameEyeClicked() {

        if (flagNameEye == FLAG_EYE_OPEN) {
            imgNameEye.setSelected(true);
            flagNameEye = FLAG_EYE_CLOSE;
        } else {
            imgNameEye.setSelected(false);
            flagNameEye = FLAG_EYE_OPEN;
        }

    }

    @OnClick(R.id.img_mine_phone_eye)
    public void onImgPhoneEyeClicked() {

        if (flagPhoneEye == FLAG_EYE_OPEN) {
            imgPhoneEye.setSelected(true);
            flagPhoneEye = FLAG_EYE_CLOSE;
        } else {
            imgPhoneEye.setSelected(false);
            flagPhoneEye = FLAG_EYE_OPEN;
        }
    }


    public void initHonorDialog() {


        dialogAddHonor =new Dialog(this,R.style.dialog_bottom);
        View inflate = LayoutInflater.from(this).inflate(R.layout.dialog_mine_honor, null);


        Window window = dialogAddHonor.getWindow();
        window.setGravity(Gravity.BOTTOM);
        android.view.WindowManager.LayoutParams layoutParams =window.getAttributes();
        layoutParams.width = WindowManager.LayoutParams.MATCH_PARENT;
        window.setAttributes(layoutParams);

        dialogAddHonor.setContentView(inflate);
        dialogAddHonor.setCancelable(true);
        dialogAddHonor.setCanceledOnTouchOutside(true);

        btnAddHonor=(Button)inflate.findViewById(R.id.btn_add_honor);
        btnCancel=(Button)inflate.findViewById(R.id.btn_cancel);


        btnAddHonor.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {


            }
        });

        btnCancel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if(dialogAddHonor!=null&&dialogAddHonor.isShowing()) {
                    dialogAddHonor.dismiss();
                }
            }
        });

    }


    @OnClick(R.id.img_mine_update_honor)
    public void onImgUpdateHonorClicked() {

        if (dialogAddHonor == null) {
            initHonorDialog();
        } else {
            dialogAddHonor.show();
        }

    }

}
