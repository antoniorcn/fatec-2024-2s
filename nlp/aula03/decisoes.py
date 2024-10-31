# temperatura < -20    ==> congelando
# temperatura < -10    ==> muito frio
# temperatura < 10    ==> frio
# temperatura < 20    ==> friozinho
# temperatura < 25    ==> agradavel
# temperatura < 30    ==> calor
# temperatura > 30    ==> muito quente

temperatura = 34

if temperatura > 30:
    print("Esta muito quente")
elif temperatura > 25:
    print("Esta calor")
elif temperatura > 20:
    print("Esta agradável")
elif temperatura > 10:
    print("Esta friozinho")
elif temperatura > -10:
    print("Esta frio")
elif temperatura > -20:
    print("Esta muito frio")
else:
    print("Esta congelando")

print("Fim do programa")