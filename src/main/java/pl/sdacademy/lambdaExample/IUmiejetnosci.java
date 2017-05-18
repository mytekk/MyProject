package pl.sdacademy.lambdaExample;

import pl.sdacademy.lambdaExample.model.Bulka;
import pl.sdacademy.lambdaExample.model.Kanapka;
import pl.sdacademy.lambdaExample.model.Maslo;
import pl.sdacademy.lambdaExample.model.Warzywo;

public interface IUmiejetnosci {

	Kanapka zrobKanapke(Bulka bulka, Maslo maslo, Warzywo warzywo);

}
