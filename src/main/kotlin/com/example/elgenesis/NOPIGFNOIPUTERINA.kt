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
        val ipUterineR = 0
        val ipUterineL = 0
        val pigf = 20


        /*var noPigf_noIpesperadoLn_pigf = (PIGF1+PIGF2*age+PIGF3 *lcc+(PIGF4)*imc)
        if (conceptionSpontaneous)
            noPigf_noIpesperadoLn_pigf += PIGF5
        if(primigestationParity)
            noPigf_noIpesperadoLn_pigf += (PIGF6)
        if(lupus)
            noPigf_noIpesperadoLn_pigf += (PIGF7)
        if(hypertension)
            noPigf_noIpesperadoLn_pigf += (PIGF8)
        if(preeclampsiaPreviousPregnancy)
            noPigf_noIpesperadoLn_pigf += (PIGF9)
        if(motherOfPatientWithPre)
            noPigf_noIpesperadoLn_pigf += (PIGF10)
        if(hypothyroidism)
            noPigf_noIpesperadoLn_pigf += (PIGF11)
        if(polycysticOvarySyndrome)
            noPigf_noIpesperadoLn_pigf += (PIGF12)
        var noPigf_noIpesperadoPigf = E.pow(noPigf_noIpesperadoLn_pigf)
        val noPigf_noIplogNaturalPigf = ln(pigf.toDouble())
        var noPigf_noIplogNaturalMomPigf = noPigf_noIplogNaturalPigf-noPigf_noIpesperadoLn_pigf
        val noPigf_noIpmomPigf = E.pow(noPigf_noIplogNaturalMomPigf)
        welcomeText.text = "$noPigf_noIpmomPigf"*/



        var noPigf_noIpesperadoLn_aut = (AUT1+AUT2*age+AUT3 *lcc)
        if (hypertension)
            noPigf_noIpesperadoLn_aut += AUT4
        if(gestationalDiabetesPreviousPregnancy)
            noPigf_noIpesperadoLn_aut += (AUT5)
        if(motherOfPatientWithPre)
            noPigf_noIpesperadoLn_aut += (AUT6)
        var noPigf_noIpesperadoAut = E.pow(noPigf_noIpesperadoLn_aut)
        val noPigf_noIplNaturalOperationAut = ((ipUterineL+ipUterineR)/2)
        val noPigf_noIplogNaturalAut = 0
        val noPigf_noIplogNaturalMomAut = noPigf_noIplogNaturalAut-noPigf_noIpesperadoLn_aut
        val noPigf_noIpmomAut = E.pow(noPigf_noIplogNaturalMomAut)


        var noPigf_noIpesperadoLn_pam = (PAM1+PAM2*age+PAM3 *lcc+(PAM4)*imc)
        if (ovulationInduction)
            noPigf_noIpesperadoLn_pam += PAM5
        if(hypertension)
            noPigf_noIpesperadoLn_pam += (PAM6)
        if(preeclampsiaPreviousPregnancy)
            noPigf_noIpesperadoLn_pam += (PAM7)
        if(motherOfPatientWithPre)
            noPigf_noIpesperadoLn_pam += (PAM8)
        if(hypothyroidism)
            noPigf_noIpesperadoLn_pam += (PAM9)
        var noPigf_noIpesperadoPam = E.pow(noPigf_noIpesperadoLn_pam)
        println("$noPigf_noIpesperadoPam")
        val noPigf_noIplNaturalOperationPam = ((systolicPressure+(2*diastolicPressure))/3)
        println("$noPigf_noIplNaturalOperationPam")
        val noPigf_noIplogNaturalPam = ln(noPigf_noIplNaturalOperationPam)
        println("$noPigf_noIplogNaturalPam")
        val noPigf_noIplogNaturalMomPam = noPigf_noIplogNaturalPam-noPigf_noIpesperadoLn_pam
        println("$noPigf_noIplogNaturalMomPam")
        val noPigf_noIpmomPam = E.pow(noPigf_noIplogNaturalMomPam)

        welcomeText.text = "$noPigf_noIpmomPam"

        var noPigf_noIpesperadoLn_pe37 = (PE37_1+PE37_2*age+PE37_3*imc+PE37_11*0+PE37_12*noPigf_noIpmomAut+PE37_13*noPigf_noIpmomPam)
        if (primigestationParity)
            noPigf_noIpesperadoLn_pe37 += PE37_4
        if(syndromeAntiphospholipid)
            noPigf_noIpesperadoLn_pe37 += (PE37_5)
        if(lupus)
            noPigf_noIpesperadoLn_pe37 += (PE37_6)
        if(drugs)
            noPigf_noIpesperadoLn_pe37 += (PE37_7)
        if(hypertension)
            noPigf_noIpesperadoLn_pe37 += (PE37_8)
        if (preeclampsiaPreviousPregnancy)
            noPigf_noIpesperadoLn_pe37 += PE37_9
        if(motherOfPatientWithPre)
            noPigf_noIpesperadoLn_pe37 += (PE37_10)


        var esperadoLn_no_pigf = (NO_PIGF1+NO_PIGF2*age+(NO_PIGF3)*imc+ NO_PIGF10*noPigf_noIpmomAut+ NO_PIGF11*noPigf_noIpmomPam)
        if (primigestationParity)
            esperadoLn_no_pigf += NO_PIGF4
        if(syndromeAntiphospholipid)
            esperadoLn_no_pigf += (NO_PIGF5)
        if(drugs)
            esperadoLn_no_pigf += (NO_PIGF6)
        if(hypertension)
            esperadoLn_no_pigf += (NO_PIGF7)
        if(motherOfPatientWithPre)
            esperadoLn_no_pigf += (NO_PIGF8)
        if(hypothyroidism)
            esperadoLn_no_pigf += (NO_PIGF9)
        var noPigf_noIp_esperadoPigf = E.pow(esperadoLn_no_pigf)
        val logNaturalPigf = ln(pigf.toDouble())
        var logNaturalMomPigf = logNaturalPigf-esperadoLn_no_pigf
        val momPigf = E.pow(logNaturalMomPigf)
        welcomeText.text = "$momPigf"


        println("$esperadoLn_no_pigf")
        println("$noPigf_noIp_esperadoPigf")
        val risk = (noPigf_noIp_esperadoPigf/(1+noPigf_noIp_esperadoPigf))
        val risk_finale = (1/risk).roundToInt()
        println("$risk")
        println("$risk_finale")


    }
}