package main.com.pcq.designpattern.factory.abstr;

import main.com.pcq.designpattern.factory.Milk;
import main.com.pcq.designpattern.factory.MengniuFactory;
import main.com.pcq.designpattern.factory.SanluFactory;
import main.com.pcq.designpattern.factory.TelunsuFactory;
import main.com.pcq.designpattern.factory.YiliFactory;

public class MilkFactory extends AbstractFactory {
    @Override
    public Milk getMengniu() {
        return new MengniuFactory().getMilk();
    }

    @Override
    public Milk getYili() {
        return new YiliFactory().getMilk();
    }

    @Override
    public Milk getTelunsu() {
        return new TelunsuFactory().getMilk();
    }

    @Override
    public Milk getSanlu() {
        return new SanluFactory().getMilk();
    }
}
