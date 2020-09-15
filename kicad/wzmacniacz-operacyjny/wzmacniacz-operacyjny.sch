EESchema Schematic File Version 4
EELAYER 30 0
EELAYER END
$Descr A4 11693 8268
encoding utf-8
Sheet 1 1
Title ""
Date ""
Rev ""
Comp ""
Comment1 ""
Comment2 ""
Comment3 ""
Comment4 ""
$EndDescr
$Comp
L Amplifier_Operational:OPA340NA U?
U 1 1 5F500672
P 1475 950
F 0 "U?" H 1819 996 50  0001 L CNN
F 1 "OPA340NA" H 1819 905 50  0001 L CNN
F 2 "Package_TO_SOT_SMD:SOT-23-5" H 1375 750 50  0001 L CNN
F 3 "http://www.ti.com/lit/ds/symlink/opa340.pdf" H 1475 1150 50  0001 C CNN
	1    1475 950 
	1    0    0    -1  
$EndComp
Text Notes 1075 875  0    39   ~ 0
IN
Text Notes 1140 1080 2    39   ~ 0
IN
Text Notes 1850 975  0    39   ~ 0
OUT\n
$Comp
L Amplifier_Operational:OPA340NA U?
U 1 1 5F505794
P 3125 925
F 0 "U?" H 3469 971 50  0001 L CNN
F 1 "OPA340NA" H 3469 880 50  0001 L CNN
F 2 "Package_TO_SOT_SMD:SOT-23-5" H 3025 725 50  0001 L CNN
F 3 "http://www.ti.com/lit/ds/symlink/opa340.pdf" H 3125 1125 50  0001 C CNN
	1    3125 925 
	1    0    0    -1  
$EndComp
Text Notes 2700 850  0    39   ~ 0
2V
Text Notes 2770 1050 2    39   ~ 0
1V
Text Notes 3450 950  0    39   ~ 0
OUT
Text Notes 3100 1125 0    39   ~ 0
K=100
$Comp
L Amplifier_Operational:OPA340NA U?
U 1 1 5F509BBD
P 5200 975
F 0 "U?" H 5544 1021 50  0001 L CNN
F 1 "OPA340NA" H 5544 930 50  0001 L CNN
F 2 "Package_TO_SOT_SMD:SOT-23-5" H 5100 775 50  0001 L CNN
F 3 "http://www.ti.com/lit/ds/symlink/opa340.pdf" H 5200 1175 50  0001 C CNN
	1    5200 975 
	1    0    0    -1  
$EndComp
Wire Wire Line
	4900 1075 4675 1075
Wire Wire Line
	4675 1075 4675 1350
Wire Wire Line
	4675 1350 5625 1350
Wire Wire Line
	5625 1350 5625 975 
Wire Wire Line
	5625 975  5500 975 
Wire Wire Line
	5625 975  5850 975 
Connection ~ 5625 975 
Text Notes 4725 850  0    50   ~ 0
1V
Text Notes 5900 1000 0    50   ~ 0
OUT
Text Notes 4725 1050 0    50   ~ 0
1V
Wire Wire Line
	4675 875  4900 875 
$Comp
L Amplifier_Operational:OPA340NA U?
U 1 1 5F50E296
P 4575 1875
F 0 "U?" H 4919 1921 50  0001 L CNN
F 1 "OPA340NA" H 4919 1830 50  0001 L CNN
F 2 "Package_TO_SOT_SMD:SOT-23-5" H 4475 1675 50  0001 L CNN
F 3 "http://www.ti.com/lit/ds/symlink/opa340.pdf" H 4575 2075 50  0001 C CNN
	1    4575 1875
	1    0    0    -1  
$EndComp
Wire Wire Line
	4275 1975 4050 1975
Wire Wire Line
	4050 1975 4050 2250
Wire Wire Line
	4050 2250 5000 2250
Wire Wire Line
	5000 2250 5000 1875
Wire Wire Line
	5000 1875 4875 1875
Wire Wire Line
	5000 1875 5225 1875
Connection ~ 5000 1875
Text Notes 4100 1750 0    50   ~ 0
1V
Text Notes 5275 1900 0    50   ~ 0
OUT
Text Notes 4100 1950 0    50   ~ 0
1V
$Comp
L Device:R R?
U 1 1 5F50ECD0
P 3300 1775
F 0 "R?" V 3093 1775 50  0001 C CNN
F 1 "R" V 3184 1775 50  0001 C CNN
F 2 "" V 3230 1775 50  0001 C CNN
F 3 "~" H 3300 1775 50  0001 C CNN
	1    3300 1775
	0    1    1    0   
$EndComp
$Comp
L Device:C C?
U 1 1 5F50F27D
P 3725 1925
F 0 "C?" H 3840 1971 50  0001 L CNN
F 1 "C" H 3840 1880 50  0001 L CNN
F 2 "" H 3763 1775 50  0001 C CNN
F 3 "~" H 3725 1925 50  0001 C CNN
	1    3725 1925
	1    0    0    -1  
$EndComp
Wire Wire Line
	3450 1775 3725 1775
Connection ~ 3725 1775
Wire Wire Line
	3725 1775 4275 1775
Wire Wire Line
	3725 2075 3725 2250
$Comp
L Amplifier_Operational:OPA340NA U?
U 1 1 5F513F34
P 3950 3000
F 0 "U?" H 4294 3046 50  0001 L CNN
F 1 "OPA340NA" H 4294 2955 50  0001 L CNN
F 2 "Package_TO_SOT_SMD:SOT-23-5" H 3850 2800 50  0001 L CNN
F 3 "http://www.ti.com/lit/ds/symlink/opa340.pdf" H 3950 3200 50  0001 C CNN
	1    3950 3000
	1    0    0    -1  
$EndComp
Wire Wire Line
	3650 3100 3425 3100
Wire Wire Line
	3425 3100 3425 3450
Wire Wire Line
	4375 3000 4250 3000
Wire Wire Line
	4375 3000 4600 3000
Connection ~ 4375 3000
Text Notes 4650 3025 0    50   ~ 0
OUT
Wire Wire Line
	3425 2900 3650 2900
$Comp
L Device:R R1
U 1 1 5F516CFA
P 4375 3250
F 0 "R1" H 4445 3250 50  0000 L CNN
F 1 "R" H 4445 3205 50  0001 L CNN
F 2 "" V 4305 3250 50  0001 C CNN
F 3 "~" H 4375 3250 50  0001 C CNN
	1    4375 3250
	1    0    0    -1  
$EndComp
Wire Wire Line
	4375 3100 4375 3000
$Comp
L Device:R R2
U 1 1 5F519291
P 4375 3625
F 0 "R2" H 4445 3625 50  0000 L CNN
F 1 "R" H 4445 3580 50  0001 L CNN
F 2 "" V 4305 3625 50  0001 C CNN
F 3 "~" H 4375 3625 50  0001 C CNN
	1    4375 3625
	1    0    0    -1  
$EndComp
Wire Wire Line
	3425 3450 4375 3450
Wire Wire Line
	4375 3400 4375 3450
Connection ~ 4375 3450
Wire Wire Line
	4375 3450 4375 3475
Wire Wire Line
	4375 3775 4375 3900
$Comp
L power:GNDREF #PWR?
U 1 1 5F51A7F8
P 4375 3900
F 0 "#PWR?" H 4375 3650 50  0001 C CNN
F 1 "GNDREF" H 4380 3727 50  0001 C CNN
F 2 "" H 4375 3900 50  0001 C CNN
F 3 "" H 4375 3900 50  0001 C CNN
	1    4375 3900
	1    0    0    -1  
$EndComp
$EndSCHEMATC
