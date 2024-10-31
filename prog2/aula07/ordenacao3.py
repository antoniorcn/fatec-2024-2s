#   a	b	c
#   a	c	b
#   b	a	c
#   b	c	a
#   c	a	b
#   c	b	a

print("Ordenacao de numeros")
print("Programação II - Jogos Digitais")

a = int(input("Por favor digite um numero:"))
b = int(input("Digite um segundo numero: "))
c = int(input("Digite um terceiro numero: "))


if a >= b:
    if c >= a:
        print(f"{b} {a} {c}")
    else:
        if c >= b:
            print(f"{b} {c} {a}")
        else:
            print(f"{c} {b} {a}")
else:
    if c >= b:
        print(f"{a} {b} {c}")
    else:
        if c <= a:
            print(f"{c} {a} {b}")
        else:
            print(f"{a} {c} {b}")


