hi_scores = [9000, 7000, 6435, 5723, 4200, 
             3199, 2955, 1323, 1243, 1111]

hi_score_names = ["JOA", "JOA", "JOA", "MIK", "MIK",
                  "STV", "BOB", "JOE", "BOB", "JOE"]

quantidade_elementos = len(hi_score_names)

indice = 0
while indice < quantidade_elementos:
    print(hi_scores[indice], hi_score_names[indice])
    indice = indice + 1