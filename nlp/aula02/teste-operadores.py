a = 10
b = 20

c = a * b
d = a ** b
e = 200 / 3
f = 200 // 3
g = 200 % 3

print("a * b ==> ", c)
print("a elevado b ==> ", d)
print("200 dividido por 3 ==>", e)
print("quociente da divisao de 200 por 3 ==>", f)
print("resto da divisao de 200 por 3 ==>", g)

"""
           exp        3  
        base        20          20 * 20 * 20

"""
#        5.0                 "5"
base = float(   input("Digite o numero para ser a base")    )
#           3.0              "3"
expoente = float(input("Digite o numero do expoente"))

resultado = base ** expoente
print(f"Resultado de {base} elevado ao {expoente} ==> ", resultado)


"""
  Dividendo    Divisor
        200 |   3
            |-------
         20     66  Quociente
    Resto 2 

"""