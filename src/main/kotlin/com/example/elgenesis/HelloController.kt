package com.example.elgenesis

import javafx.fxml.FXML
import javafx.scene.control.Label
import kotlin.math.E
import kotlin.math.ln
import kotlin.math.pow

const val PIGF1 = 2.019266
const val PIGF2 = 0.0028178
const val PIGF3 = 0.0191399
const val PIGF4 = -0.011891
const val PIGF5 = 0.2036425
const val PIGF6 = -0.04644928
const val PIGF7 = -0.3163534
const val PIGF8 = -0.1000511
const val PIGF9 = -0.1111554
const val PIGF10 = -0.0915202
const val PIGF11 = -0.1066501
const val PIGF12 = -0.1206829
const val AUT1 = 0.8400363
const val AUT2 = -0.0023316
const val AUT3 = -0.0059239
const val AUT4 = 0.0750184
const val AUT5 = -0.211569
const val AUT6 = 0.1409438
const val PAM1 = 4.169324
const val PAM2 = 0.0010257
const val PAM3 = -0.0008
const val PAM4 = 0.0065639
const val PAM5 = -0.0569733
const val PAM6 = 0.0499594
const val PAM7 = 0.0290743
const val PAM8 = 0.044145
const val PAM9 = -0.0232769
const val PE37_1 = -14.36478
const val PE37_2 = 0.0580772
const val PE37_3 = 0.0613086
const val PE37_4 = 0.8714025
const val PE37_5 = 4.573636
const val PE37_6 = -3.432967
const val PE37_7 = 2.033507
const val PE37_8 = 1.668535
const val PE37_9 = 1.086105
const val PE37_10 = 1.246044
const val PE37_11 = -4.7355900
const val PE37_12 = 1.3124590
const val PE37_13 = 8.2557680



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
        val logNaturalPigf = ln(pigf.toDouble())
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
            esperadoLn_pigf += PAM5
        if(hypertension)
            esperadoLn_pigf += (PAM6)
        if(preeclampsiaPreviousPregnancy)
            esperadoLn_pigf += (PAM7)
        if(motherOfPatientWithPre)
            esperadoLn_pigf += (PAM8)
        if(hypothyroidism)
            esperadoLn_pigf += (PAM9)
        var esperadoPam = E.pow(esperadoLn_pam)
        println("$esperadoPam")
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
        println("$risk")

    }
}