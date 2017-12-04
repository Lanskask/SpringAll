package ru.smurtazin.justsomeexperiments.pakTest;

public class RawExperiment {

    SomeObjBuilder manBuilder = new SomeObjBuilder();

    Man man = new Man();

    void initMan() {
        this.man = this.manBuilder.enhanceMan(this.man)
                .setManName("name")
                .setManSurName("surname")
//                .setAge(55)
                .setIsMale(true)
                .getResultMan();
        assert (this.man != null);
    }

    public static void main(String[] args) {
        RawExperiment rawExperiment = new RawExperiment();
        rawExperiment.initMan();
    }

}
