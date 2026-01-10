#!/usr/bin/env python3
import json

# Base template for creating comprehensive medical guides
guides = []

# Keep all existing 25 guides and add 200+ more
# I'll structure this efficiently by category

# EXISTING CRITICAL GUIDES (10) - keeping as is
existing_critical = [
    "cpr_adult", "cpr_child", "cpr_infant", "choking_adult", "choking_child",
    "heart_attack", "stroke", "severe_bleeding", "anaphylaxis", "drowning"
]

# NEW EMERGENCY & CRITICAL (20 more)
new_critical = [
    ("asthma_severe", "Severe Asthma Attack", "Shambulio Kali la Pumu", "asthma, breathing, inhaler, pumu"),
    ("diabetic_low", "Low Blood Sugar (Hypoglycemia)", "Sukari Chini (Hypoglycemia)", "diabetes, sugar, kisukari"),
    ("diabetic_high", "High Blood Sugar (Hyperglycemia)", "Sukari Juu (Hyperglycemia)", "diabetes, thirst, kisukari"),
    ("seizure_status", "Status Epilepticus (Prolonged Seizure)", "Kifafa Kirefu", "seizure, convulsion, kifafa"),
    ("respiratory_failure", "Respiratory Failure", "Kushindwa Kupumua", "breathing, oxygen, pumzi"),
    ("cardiac_arrest_child", "Cardiac Arrest (Child)", "Moyo Kusimama (Mtoto)", "heart, child, moyo"),
    ("trauma_major", "Major Trauma", "Jeraha Kubwa", "accident, injury, ajali"),
    ("spinal_injury", "Suspected Spinal Injury", "Ushuku wa Jeraha la Uti wa Mgongo", "spine, neck, uti"),
    ("internal_bleeding", "Internal Bleeding", "Kutokwa Damu Ndani", "abdomen, bleeding, tumbo"),
    ("shock_septic", "Septic Shock", "Mshtuko wa Maambukizi", "infection, fever, maambukizi"),
    ("electrocution", "Electrocution", "Kushikwa na Umeme", "electric, shock, umeme"),
    ("carbon_monoxide", "Carbon Monoxide Poisoning", "Sumu ya Carbon Monoxide", "gas, poisoning, sumu"),
    ("hypothermia_severe", "Severe Hypothermia", "Baridi Kali", "cold, freezing, baridi"),
    ("heat_stroke_severe", "Severe Heat Stroke", "Joto Kali", "heat, temperature, joto"),
    ("allergic_severe", "Severe Allergic Reaction", "Mzio Mkubwa", "allergy, swelling, mzio"),
    ("bleeding_arterial", "Arterial Bleeding", "Kutokwa Damu kwa Mishipa", "artery, blood, damu"),
    ("amputation_traumatic", "Traumatic Amputation", "Kukatwa Kwa Ghafla", "amputation, limb, mkono"),
    ("crush_injury", "Crush Injury", "Jeraha la Kusongwa", "crush, trapped, kusongwa"),
    ("gunshot_wound", "Gunshot Wound", "Jeraha la Risasi", "gunshot, bullet, risasi"),
    ("stab_wound", "Stab Wound", "Jeraha la Kuchomwa", "stab, knife, kisu")
]

# COMMON INJURIES (25)
injuries = [
    ("cut_minor", "Minor Cuts", "Mikato Midogo", "cut, wound, mkato"),
    ("cut_deep", "Deep Cuts", "Mikato Mirefu", "cut, deep, mkato"),
    ("puncture_wound", "Puncture Wound", "Jeraha la Kutoboa", "puncture, nail, msumari"),
    ("abrasion", "Abrasions (Scrapes)", "Mikwaruzo", "scrape, graze, mkwaruzo"),
    ("bruise", "Bruises (Contusions)", "Michubuko", "bruise, bump, mchubuko"),
    ("black_eye", "Black Eye", "Jicho Jeusi", "eye, bruise, jicho"),
    ("nose_injury", "Nose Injury", "Jeraha la Pua", "nose, broken, pua"),
    ("ear_injury", "Ear Injury", "Jeraha la Sikio", "ear, bleeding, sikio"),
    ("finger_injury", "Finger Injury", "Jeraha la Kidole", "finger, hand, kidole"),
    ("toe_injury", "Toe Injury", "Jeraha la Kidole cha Mguu", "toe, foot, kidole"),
    ("ankle_sprain", "Ankle Sprain", "Kulegea Kifundo", "ankle, sprain, kifundo"),
    ("wrist_sprain", "Wrist Sprain", "Kulegea Mkono", "wrist, sprain, mkono"),
    ("knee_injury", "Knee Injury", "Jeraha la Goti", "knee, pain, goti"),
    ("shoulder_injury", "Shoulder Injury", "Jeraha la Bega", "shoulder, pain, bega"),
    ("dislocation", "Joint Dislocation", "Kiungo Kutoka", "dislocation, joint, kiungo"),
    ("muscle_strain", "Muscle Strain", "Kulegea Misuli", "muscle, pull, misuli"),
    ("tendon_injury", "Tendon Injury", "Jeraha la Mkwamba", "tendon, pain, mkwamba"),
    ("ligament_tear", "Ligament Tear", "Mkwamba Kukatika", "ligament, tear, mkwamba"),
    ("back_strain", "Back Strain", "Maumivu ya Mgongo", "back, pain, mgongo"),
    ("neck_strain", "Neck Strain", "Maumivu ya Shingo", "neck, pain, shingo"),
    ("splinter", "Splinter Removal", "Kuondoa Kijiti", "splinter, wood, kijiti"),
    ("fishhook_injury", "Fishhook Injury", "Jeraha la Ndoana", "fishhook, hook, ndoana"),
    ("animal_bite_dog", "Dog Bite", "Kuumwa na Mbwa", "dog, bite, mbwa"),
    ("animal_bite_cat", "Cat Scratch/Bite", "Kurarumwa/Kuumwa na Paka", "cat, scratch, paka"),
    ("human_bite", "Human Bite", "Kuumwa na Mtu", "bite, human, mtu")
]

# COMMON ILLNESSES (30)
illnesses = [
    ("fever_adult", "Fever (Adult)", "Homa (Mtu Mzima)", "fever, temperature, homa"),
    ("fever_child", "Fever (Child)", "Homa (Mtoto)", "fever, child, homa"),
    ("fever_infant", "Fever (Infant)", "Homa (Mtoto Mchanga)", "fever, baby, homa"),
    ("common_cold", "Common Cold", "Mafua", "cold, runny nose, mafua"),
    ("flu_influenza", "Influenza (Flu)", "Homa ya Mafua", "flu, influenza, homa"),
    ("cough_dry", "Dry Cough", "Kikohozi Kavu", "cough, dry, kikohozi"),
    ("cough_productive", "Productive Cough", "Kikohozi chenye Kohozi", "cough, phlegm, kikohozi"),
    ("sore_throat", "Sore Throat", "Maumivu ya Koo", "throat, pain, koo"),
    ("tonsillitis", "Tonsillitis", "Uvimbe wa Tonsils", "tonsils, throat, koo"),
    ("strep_throat", "Strep Throat", "Koo Kuumwa", "strep, throat, koo"),
    ("bronchitis", "Bronchitis", "Uvimbe wa Bronchi", "bronchitis, cough, kikohozi"),
    ("pneumonia", "Pneumonia", "Nimonia", "pneumonia, lungs, mapafu"),
    ("diarrhea_acute", "Acute Diarrhea", "Kuhara Ghafla", "diarrhea, loose stool, kuhara"),
    ("diarrhea_chronic", "Chronic Diarrhea", "Kuhara Kwa Muda", "diarrhea, persistent, kuhara"),
    ("vomiting", "Vomiting", "Kutapika", "vomit, nausea, kutapika"),
    ("food_poisoning", "Food Poisoning", "Sumu ya Chakula", "food, poisoning, chakula"),
    ("gastroenteritis", "Gastroenteritis (Stomach Flu)", "Homa ya Tumbo", "stomach, flu, tumbo"),
    ("constipation", "Constipation", "Kustaafu", "constipation, bowel, kustaafu"),
    ("uti_adult", "Urinary Tract Infection (Adult)", "Maambukizi ya Mkojo", "uti, urine, mkojo"),
    ("uti_child", "Urinary Tract Infection (Child)", "Maambukizi ya Mkojo (Mtoto)", "uti, child, mkojo"),
    ("ear_infection", "Ear Infection (Otitis Media)", "Maambukizi ya Sikio", "ear, infection, sikio"),
    ("swimmers_ear", "Swimmer's Ear (Otitis Externa)", "Sikio la Mwogeleaji", "ear, swimmer, sikio"),
    ("pink_eye", "Pink Eye (Conjunctivitis)", "Jicho Jekundu", "eye, pink, jicho"),
    ("stye", "Stye (Eye)", "Tone la Jicho", "stye, eye, tone"),
    ("sinusitis", "Sinus Infection (Sinusitis)", "Maambukizi ya Pua", "sinus, congestion, pua"),
    ("headache_tension", "Tension Headache", "Maumivu ya Kichwa ya Msongo", "headache, tension, kichwa"),
    ("headache_migraine", "Migraine Headache", "Maumivu Makali ya Kichwa", "migraine, headache, kichwa"),
    ("dehydration", "Dehydration", "Ukosefu wa Maji", "dehydration, thirst, maji"),
    ("oral_thrush", "Oral Thrush", "Ukungu wa Kinywa", "thrush, mouth, kinywa"),
    ("yeast_infection", "Yeast Infection", "Maambukizi ya Kuvu", "yeast, infection, kuvu")
]

print(f"Will generate {len(new_critical) + len(injuries) + len(illnesses) + 10} guides so far...")
print("This is just the first batch - continuing with more categories...")
