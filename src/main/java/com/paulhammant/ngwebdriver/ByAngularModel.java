package com.paulhammant.ngwebdriver;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.SearchContext;
import org.openqa.selenium.WebDriver;

public class ByAngularModel extends ByAngular.BaseBy {

    public ByAngularModel(String model) {
        super();
        this.model = model;
    }

    private String model;

    protected Object getObject(SearchContext context, JavascriptExecutor javascriptExecutor) {
        if (context instanceof WebDriver) {
            context = null;
        }
        Object o = javascriptExecutor.executeScript(
                "var using = arguments[0] || document;\n" +
                        "var rootSelector = 'body';\n" +
                        "var model = '" + model + "';\n" +
                        "\n" +
                        ByAngular.functions.get("findByModel")
                , context);
        errorIfNull(o);
        return o;
    }

    @Override
    public String toString() {
        return "model(" + model + ')';
    }
}
