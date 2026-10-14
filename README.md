# Demonstração de Comparação de Objetos Integer em Java

## Descrição

Este programa demonstra a diferença entre comparar referências de objetos e comparar seus valores na linguagem Java, utilizando a classe `Integer`.

O exemplo utiliza os operadores `==` e o método `equals()` para comparar objetos que armazenam números inteiros.

O objetivo é mostrar que dois objetos podem conter o mesmo valor numérico sem necessariamente serem o mesmo objeto na memória. O programa também demonstra o comportamento do cache de objetos `Integer`, utilizado pelo Java para determinados valores inteiros.

## Objetivos

- Compreender a diferença entre tipos primitivos e classes wrapper.
- Conhecer a classe `Integer` e o mecanismo de autoboxing.
- Diferenciar a comparação de referências da comparação de valores.
- Entender o comportamento do cache de objetos `Integer`.
- Utilizar corretamente o método `equals()` para comparar valores de objetos.

## Funcionamento do programa

O programa realiza duas comparações, utilizando valores pequenos e valores maiores.

### 1. Comparando valores pequenos

```java
Integer a = 100;
Integer b = 100;

System.out.println(a == b);
System.out.println(a.equals(b));
```

As variáveis `a` e `b` são do tipo `Integer`, uma classe wrapper que encapsula valores inteiros.

Ao atribuir o valor `100`, o Java utiliza o mecanismo de autoboxing para converter automaticamente o valor primitivo em um objeto `Integer`.

A implementação padrão do Java mantém um cache de objetos `Integer` para valores entre `-128` e `127`. Como `100` está nessa faixa, as duas atribuições normalmente reutilizam a mesma referência.

Por isso:

- `a == b` retorna `true`, pois as referências apontam para o mesmo objeto.
- `a.equals(b)` retorna `true`, pois os valores numéricos são iguais.

### 2. Comparando valores maiores

```java
Integer c = 1000;
Integer d = 1000;

System.out.println(c == d);
System.out.println(c.equals(d));
```

O valor `1000` está fora da faixa padrão do cache de `Integer`.

Nesse caso, as atribuições normalmente produzem objetos distintos, mesmo que ambos armazenem o valor `1000`.

Por isso:

- `c == d` retorna `false`, pois as referências apontam para objetos diferentes.
- `c.equals(d)` retorna `true`, pois os valores armazenados são iguais.

O comportamento observado em `==` depende do cache e não deve ser utilizado como uma forma de comparar valores numéricos de objetos.

## Código-fonte

O arquivo `Principal.java` contém a implementação completa do programa.

## Como executar

É necessário ter o Java Development Kit (JDK) e o Apache Maven instalados. O projeto contêm o arquivo `pom.xml` na raiz do diretório.

**1. Compile o projeto**

```bash
mvn compile
```

O Maven compila os arquivos-fonte do projeto e verifica se existem erros de compilação.

**2. Execute o programa**

```bash
mvn exec:java -Dexec.mainClass="Principal"
```

## Saída esperada

Em uma execução típica do Java, a saída será:

```text
1. Comparando valores pequenos
a = 100
b = 100
a == b: true
a.equals(b): true

2. Comparando valores maiores
c = 1000
d = 1000
c == d: false
c.equals(d): true
```

## Conceitos fundamentais

### Classe wrapper `Integer`

A classe `Integer` encapsula um valor primitivo do tipo `int` em um objeto.

Por exemplo:

```java
int numeroPrimitivo = 100;
Integer numeroObjeto = 100;
```

O Java realiza automaticamente a conversão do valor primitivo para o objeto por meio do mecanismo chamado *autoboxing*.

### Operador `==`

Quando utilizado com variáveis que referenciam objetos, o operador `==` verifica se ambas apontam para o mesmo objeto.

Ele não compara diretamente os valores encapsulados nos objetos.

### Método `equals()`

O método `equals()` da classe `Integer` compara os valores inteiros armazenados nos objetos.

Por isso, dois objetos `Integer` diferentes podem retornar `true` quando comparados com `equals()`, desde que contenham o mesmo valor numérico.

### Cache de objetos `Integer`

O Java mantém um cache para determinados valores de `Integer`. A faixa padrão garantida para esse cache vai de `-128` a `127`.

Esse mecanismo permite reutilizar objetos e pode reduzir a necessidade de criar novas instâncias.

A implementação pode oferecer cache para valores adicionais, dependendo da configuração e da JVM utilizada. Portanto, não se deve depender de `==` para comparar valores de objetos `Integer`.

## Comparação dos resultados

| Expressão | O que compara? | Resultado esperado |
|---|---|---|
| `a == b` | Referências dos objetos | `true` |
| `a.equals(b)` | Valores numéricos | `true` |
| `c == d` | Referências dos objetos | `false` |
| `c.equals(d)` | Valores numéricos | `true` |

## Conclusão

O programa demonstra que comparar objetos não é o mesmo que comparar seus conteúdos.

O operador `==` verifica a identidade das referências, enquanto `equals()` compara os valores armazenados pelos objetos `Integer`.

Para comparar valores numéricos encapsulados em objetos, a recomendação é utilizar `equals()`. Quando os valores forem convertidos para tipos primitivos, como `int`, o operador `==` poderá ser utilizado para comparar os próprios valores numéricos.

Compreender essa diferença ajuda a evitar erros de comparação e a entender melhor o funcionamento dos objetos e das referências em Java.