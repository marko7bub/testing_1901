package ua.edu.ucu.smartarr;

import java.util.HashMap;
import java.util.Map;

public class Main {
    boolean darkModeSelected = (!darkModeSelected);

    String[] namesList = new String[]{"cName", "cCode", "cAlpha2", "cAbreviation",
            "dYear", "dPoliticalCompatibility", "dRankPoliticalCompatibility",
            "dEconomicCompatibility", "dRankEconomicCompatibility"};

    Map<String, Object> namesMap = new HashMap<String, Object>();

    for (int i = 0; i < 8; i++) {
        namesMap.put(namesList[i], InpList.get(i).replace(",", "."));
    }

    @Override
    public void afterTextChanged (Editable s, int paymentType) {
        if (s.length() == 9){
            if (paymentType == 1 || paymentType == 0){
                etPaymentAmount.requestFocus();
            }
        }
    }
    int number = -1;
    String[] numbersListThree = new String[]{("three", "3", "３", "三", "삼"};
    String[] numbersListTwo = new String[]{("two", "2", "２", "二", "이"};
    String[] numbersListOne = new String[]{("one", "1", "１", "二", "이"};
    for (String res : result) {
        for (String three : numbersListThree){
            if (res.toLowerCase().contains(three)){
                number = 3;
            }
        }
        for (String two : numbersListTwo){
            if (res.toLowerCase().contains(two)){
                number = 2;
            }
        }
        for (String one : numbersListOne){
            if (res.toLowerCase().contains(one)){
                number = 1;
            }
        }
    }

}
