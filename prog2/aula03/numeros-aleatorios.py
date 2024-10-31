from random import random, seed, randint
# semente = 239
# seed( semente )
numero_aleatorio = random()
numero_inteiro = round(numero_aleatorio * 100)

print(f"Numero Aleatorio: {numero_aleatorio}")
print(f"Numero Inteiro: {numero_inteiro}")

numero_aleatorio = random()
numero_inteiro = round(numero_aleatorio * 100)

print(f"Numero Aleatorio: {numero_aleatorio}")
print(f"Numero Inteiro: {numero_inteiro}")

# numero_aleatorio = random()
# numero_inteiro = round(numero_aleatorio * 100)
print("Numero entre 1 e 60:")
numero_aleatorio = randint(1, 60)
print(f"Numero Aleatorio Inteiro: {numero_aleatorio}")
