package com.ugb.conversores;

import java.text.DecimalFormat;


class Conversor {
    double[] valores = {1, 0.1329421, 0.111111, 0.092903, 0.00014775, 0.00001319, 0.000009,};
    Conversor() {
    }

    public double convertir_area(int de, int a, double cantidad) {
        DecimalFormat twoDForm = new DecimalFormat("#.#####");
        double[] dArr = this.valores;
        return Double.parseDouble(twoDForm.format((dArr[a] / dArr[de]) * cantidad));
    }
}
