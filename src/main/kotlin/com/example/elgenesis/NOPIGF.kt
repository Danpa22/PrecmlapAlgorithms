package com.example.elgenesis

import javafx.fxml.FXML
import javafx.scene.control.Label
import kotlin.math.E
import kotlin.math.ln
import kotlin.math.pow
import kotlin.math.roundToInt


class HelloController {
    @FXML
    private lateinit var welcomeText: Label

    @FXML
    private fun onHelloButtonClick() {

        val age = 35
        val weight = 60
        val height = 160
        val lcc = 55
        val imc = (weight/(height.toDouble().pow(2.0)))*(10000)
        val conceptionSpontaneous = true
        val ovulationInduction = false
        val primigestationParity = true
        val syndromeAntiphospholipid = false
        val lupus = false
        val drugs = false
        val hypertension = false
        val preeclampsiaPreviousPregnancy = false
        val gestationalDiabetesPreviousPregnancy = false
        val motherOfPatientWithPre = false
        val hypothyroidism = false
        val uncorrectedMaternalHeartDisease = false
        val polycysticOvarySyndrome = false
        val pegAntecedents = false
        val systolicPressure = 100.0
        val diastolicPressure = 68.0
        val ipUterineR = 1.7
        val ipUterineL = 1.6
        val pigf = 20

        var esperadoLn_pigf = (PIGF1+PIGF2*age+PIGF3 *lcc+(PIGF4)*imc)
        if (conceptionSpontaneous)
            esperadoLn_pigf += PIGF5
        if(primigestationParity)
            esperadoLn_pigf += (PIGF6)
        if(lupus)
            esperadoLn_pigf += (PIGF7)
        if(hypertension)
            esperadoLn_pigf += (PIGF8)
        if(preeclampsiaPreviousPregnancy)
            esperadoLn_pigf += (PIGF9)
        if(motherOfPatientWithPre)
            esperadoLn_pigf += (PIGF10)
        if(hypothyroidism)
            esperadoLn_pigf += (PIGF11)
        if(polycysticOvarySyndrome)
            esperadoLn_pigf += (PIGF12)
        var esperadoPigf = E.pow(esperadoLn_pigf)
        val logNaturalPigf = 0
        var logNaturalMomPigf = logNaturalPigf-esperadoLn_pigf
        val momPigf = E.pow(logNaturalMomPigf)
        welcomeText.text = "$momPigf"

        var esperadoLn_aut = (AUT1+AUT2*age+AUT3 *lcc)
        if (hypertension)
            esperadoLn_aut += AUT4
        if(gestationalDiabetesPreviousPregnancy)
            esperadoLn_aut += (AUT5)
        if(motherOfPatientWithPre)
            esperadoLn_aut += (AUT6)
        var esperadoAut = E.pow(esperadoLn_aut)
        val lNaturalOperationAut = ((ipUterineL+ipUterineR)/2)
        val logNaturalAut = ln(lNaturalOperationAut)
        val logNaturalMomAut = logNaturalAut-esperadoLn_aut
        val momAut = E.pow(logNaturalMomAut)


        var esperadoLn_pam = (PAM1+PAM2*age+PAM3 *lcc+(PAM4)*imc)
        if (ovulationInduction)
            esperadoLn_pam += PAM5
        if(hypertension)
            esperadoLn_pam += (PAM6)
        if(preeclampsiaPreviousPregnancy)
            esperadoLn_pam += (PAM7)
        if(motherOfPatientWithPre)
            esperadoLn_pam += (PAM8)
        if(hypothyroidism)
            esperadoLn_pam += (PAM9)
        var esperadoPam = E.pow(esperadoLn_pam)
        val lNaturalOperationPam = ((systolicPressure+(2*diastolicPressure))/3)
        println("$lNaturalOperationPam")
        val logNaturalPam = ln(lNaturalOperationPam)
        println("$logNaturalPam")
        val logNaturalMomPam = logNaturalPam-esperadoLn_pam
        println("$logNaturalMomPam")
        val momPam = E.pow(logNaturalMomPam)

        welcomeText.text = "$momPam"

        var esperadoLn_pe37 = (PE37_1+PE37_2*age+PE37_3*imc+PE37_11*momPigf+PE37_12*momAut+PE37_13*momPam)
        if (primigestationParity)
            esperadoLn_pe37 += PE37_4
        if(syndromeAntiphospholipid)
            esperadoLn_pe37 += (PE37_5)
        if(lupus)
            esperadoLn_pe37 += (PE37_6)
        if(drugs)
            esperadoLn_pe37 += (PE37_7)
        if(hypertension)
            esperadoLn_pe37 += (PE37_8)
        if (preeclampsiaPreviousPregnancy)
            esperadoLn_pe37 += PE37_9
        if(motherOfPatientWithPre)
            esperadoLn_pe37 += (PE37_10)


        val esperadoPe37 = E.pow(esperadoLn_pe37)
        println("$esperadoPe37")
        val risk = (esperadoPe37/(1+esperadoPe37))
        val risk_finale = (1/risk).roundToInt()
        println("$risk")
        println("$risk_finale")

    }
}