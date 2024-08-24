temperatura = 19

agradavel = temperatura > 16  or  temperatura < 20 
# Operador OU (or)
#      E     |     E     |    S
#    True    |    True   |   True
#    True    |    False  |   True   
#    False   |    True   |   True
#    False   |    False  |   False

agradavel = temperatura > 16  and  temperatura < 20 
# Operador E (and)
#      E     |     E     |    S
#    True    |    True   |   True
#    True    |    False  |   False   
#    False   |    True   |   False
#    False   |    False  |   False

agradavel = temperatura > 16  ^  temperatura < 20 
# Operador Ou exclusivo (eXclusiveOR)
#   Homem    |    Mulher |    S
#    True    |    True   |   False
#    True    |    False  |   True   
#    False   |    True   |   True
#    False   |    False  |   False

print("Agradavel: " + str(agradavel))