
package com.holik.simpeg.client.application.profile;

import com.google.gwt.uibinder.client.UiBinder;
import com.google.gwt.uibinder.client.UiField;
import com.google.gwt.user.client.ui.Widget;
import com.gwtplatform.mvp.client.ViewImpl;
import gwt.material.design.client.constants.DatePickerLanguage;
import gwt.material.design.client.ui.MaterialDatePicker;
import java.util.Date;

import javax.inject.Inject;

public class ProfileView extends ViewImpl implements ProfilePresenter.MyView {
    interface Binder extends UiBinder<Widget, ProfileView> {
    }
    
    @UiField
    MaterialDatePicker dplahir,tmtcpns,tmtpns,dpspmt,tmtstruktural,
            tmtjft,tmtjfu,dpdokter,dpnarkoba,dpskck,
            dpaktalahir,dpaktamati,dpnpwp;

    @Inject
    ProfileView(Binder uiBinder) {
        initWidget(uiBinder.createAndBindUi(this));
        dplahir.setDate(new Date());
        tmtcpns.setDate(new Date());
        tmtpns.setDate(new Date());
        dpspmt.setDate(new Date());
        tmtstruktural.setDate(new Date());
        tmtjft.setDate(new Date());
        tmtjfu.setDate(new Date());
        dpdokter.setDate(new Date());
        dpnarkoba.setDate(new Date());
        dpskck.setDate(new Date());
        dpaktalahir.setDate(new Date());
        dpaktamati.setDate(new Date());
        dpnpwp.setDate(new Date());
        
        dplahir.setLanguage(DatePickerLanguage.ID);
        tmtcpns.setLanguage(DatePickerLanguage.ID);
        tmtpns.setLanguage(DatePickerLanguage.ID);
        dpspmt.setLanguage(DatePickerLanguage.ID);
        tmtstruktural.setLanguage(DatePickerLanguage.ID);
        tmtjft.setLanguage(DatePickerLanguage.ID);
        dpdokter.setLanguage(DatePickerLanguage.ID);
        dpnarkoba.setLanguage(DatePickerLanguage.ID);
        dpskck.setLanguage(DatePickerLanguage.ID);
        dpaktalahir.setLanguage(DatePickerLanguage.ID);
        dpaktamati.setLanguage(DatePickerLanguage.ID);
        dpnpwp.setLanguage(DatePickerLanguage.ID);
        
    }
}
