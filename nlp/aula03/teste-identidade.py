class Aluno:
    nome = "anonimo"
    ra = "00000"

    def __eq__(self, outro):
        igual = self.nome == outro.nome \
                and self.ra == outro.ra
        return igual
       
    def __add__(self, outro):
        a = Aluno()
        a.nome = self.nome + " e " + outro.nome
        a.ra = self.ra + "/" + outro.ra
        return a 
    
    def __str__(self):
        return f"Ra: ({self.ra})\tNome: ({self.nome})"
    



a1 = Aluno()
a1.nome = "Joao"
a1.ra = "00001"

a2 = Aluno()
a2.nome = "Maria"
a2.ra = "00002"

a3 = Aluno()
a3.nome = "Joao"
a3.ra = "00001"

a4 = a1

print("Testando A4 e A1")
if a1 == a4:
    print("Tem os mesmo valores")
else: 
    print("Tem valores diferentes")

if a1 is a4:
    print("São o mesmo objeto")
else:
    print("São objetos diferentes")

print("Testando A3 e A1")
if a1 == a3:
    print("Tem os mesmo valores")
else: 
    print("Tem valores diferentes")
if a1 is a3:
    print("São o mesmo objeto")
else:
    print("São objetos diferentes")



print("Soma do a1 + a3: ", (a1 + a2))
# a5 = a1 + a2
# print(a5.nome)
# print(a5.ra)