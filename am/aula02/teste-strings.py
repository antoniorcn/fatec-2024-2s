print("Digite um texto: ")
texto = input()
texto_maiusculo = texto.upper()
texto_minusculo = texto.lower()
tamanho = len(texto)


print("Texto: ", texto)
print("Texto Maiusculo: ", texto_maiusculo)
print("Texto Minusculo: ", texto_minusculo)
print("Tamanho do Texto: ", tamanho)

print("Letra (a): ", texto.find('a'))
print("Letra (e): ", texto.find('e'))
print("Letra (i): ", texto.find('i'))
print("Letra (o): ", texto.find('o'))
print("Letra (u): ", texto.find('u'))