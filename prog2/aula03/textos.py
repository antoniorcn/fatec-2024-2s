#        0123456789...
texto = "Aula de Prog2 na Fatec Carapicuiba"

tamanho = len(texto)

print("Texto: " + texto)
print("Texto em maiusculo: " + texto.upper())
print("Texto em minusculo: " + texto.lower())
print("Tamanho: " + str(tamanho))

pos = texto.upper().find("FATEC")

print("Posicao do Fatec no Texto: " + str(pos))