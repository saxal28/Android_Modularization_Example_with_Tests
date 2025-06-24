package com.example.ud1_modularization_example_2.data.pokemon.model;

@kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u0000>\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u001c\n\u0002\u0010\u000b\n\u0002\b\u0004\b\u0086\b\u0018\u00002\u00020\u0001Ba\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0003\u0012\u0006\u0010\u0007\u001a\u00020\u0003\u0012\b\u0010\b\u001a\u0004\u0018\u00010\u0003\u0012\u0006\u0010\t\u001a\u00020\n\u0012\f\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\r0\f\u0012\f\u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\u000f0\f\u0012\f\u0010\u0010\u001a\b\u0012\u0004\u0012\u00020\u00110\f\u00a2\u0006\u0002\u0010\u0012J\t\u0010\"\u001a\u00020\u0003H\u00c6\u0003J\t\u0010#\u001a\u00020\u0005H\u00c6\u0003J\t\u0010$\u001a\u00020\u0003H\u00c6\u0003J\t\u0010%\u001a\u00020\u0003H\u00c6\u0003J\u0010\u0010&\u001a\u0004\u0018\u00010\u0003H\u00c6\u0003\u00a2\u0006\u0002\u0010\u0016J\t\u0010\'\u001a\u00020\nH\u00c6\u0003J\u000f\u0010(\u001a\b\u0012\u0004\u0012\u00020\r0\fH\u00c6\u0003J\u000f\u0010)\u001a\b\u0012\u0004\u0012\u00020\u000f0\fH\u00c6\u0003J\u000f\u0010*\u001a\b\u0012\u0004\u0012\u00020\u00110\fH\u00c6\u0003J|\u0010+\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00032\b\b\u0002\u0010\u0007\u001a\u00020\u00032\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u00032\b\b\u0002\u0010\t\u001a\u00020\n2\u000e\b\u0002\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\r0\f2\u000e\b\u0002\u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\u000f0\f2\u000e\b\u0002\u0010\u0010\u001a\b\u0012\u0004\u0012\u00020\u00110\fH\u00c6\u0001\u00a2\u0006\u0002\u0010,J\u0013\u0010-\u001a\u00020.2\b\u0010/\u001a\u0004\u0018\u00010\u0001H\u00d6\u0003J\t\u00100\u001a\u00020\u0003H\u00d6\u0001J\t\u00101\u001a\u00020\u0005H\u00d6\u0001R\u001c\u0010\u0010\u001a\b\u0012\u0004\u0012\u00020\u00110\f8\u0006X\u0087\u0004\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u0014R\u001a\u0010\b\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004\u00a2\u0006\n\n\u0002\u0010\u0017\u001a\u0004\b\u0015\u0010\u0016R\u0016\u0010\u0006\u001a\u00020\u00038\u0006X\u0087\u0004\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0018\u0010\u0019R\u0016\u0010\u0002\u001a\u00020\u00038\u0006X\u0087\u0004\u00a2\u0006\b\n\u0000\u001a\u0004\b\u001a\u0010\u0019R\u0016\u0010\u0004\u001a\u00020\u00058\u0006X\u0087\u0004\u00a2\u0006\b\n\u0000\u001a\u0004\b\u001b\u0010\u001cR\u0016\u0010\t\u001a\u00020\n8\u0006X\u0087\u0004\u00a2\u0006\b\n\u0000\u001a\u0004\b\u001d\u0010\u001eR\u001c\u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\u000f0\f8\u0006X\u0087\u0004\u00a2\u0006\b\n\u0000\u001a\u0004\b\u001f\u0010\u0014R\u001c\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\r0\f8\u0006X\u0087\u0004\u00a2\u0006\b\n\u0000\u001a\u0004\b \u0010\u0014R\u0016\u0010\u0007\u001a\u00020\u00038\u0006X\u0087\u0004\u00a2\u0006\b\n\u0000\u001a\u0004\b!\u0010\u0019\u00a8\u00062"}, d2 = {"Lcom/example/ud1_modularization_example_2/data/pokemon/model/PokemonDetail;", "", "id", "", "name", "", "height", "weight", "baseExperience", "sprites", "Lcom/example/ud1_modularization_example_2/data/pokemon/model/PokemonSprites;", "types", "", "Lcom/example/ud1_modularization_example_2/data/pokemon/model/PokemonType;", "stats", "Lcom/example/ud1_modularization_example_2/data/pokemon/model/PokemonStat;", "abilities", "Lcom/example/ud1_modularization_example_2/data/pokemon/model/PokemonAbility;", "(ILjava/lang/String;IILjava/lang/Integer;Lcom/example/ud1_modularization_example_2/data/pokemon/model/PokemonSprites;Ljava/util/List;Ljava/util/List;Ljava/util/List;)V", "getAbilities", "()Ljava/util/List;", "getBaseExperience", "()Ljava/lang/Integer;", "Ljava/lang/Integer;", "getHeight", "()I", "getId", "getName", "()Ljava/lang/String;", "getSprites", "()Lcom/example/ud1_modularization_example_2/data/pokemon/model/PokemonSprites;", "getStats", "getTypes", "getWeight", "component1", "component2", "component3", "component4", "component5", "component6", "component7", "component8", "component9", "copy", "(ILjava/lang/String;IILjava/lang/Integer;Lcom/example/ud1_modularization_example_2/data/pokemon/model/PokemonSprites;Ljava/util/List;Ljava/util/List;Ljava/util/List;)Lcom/example/ud1_modularization_example_2/data/pokemon/model/PokemonDetail;", "equals", "", "other", "hashCode", "toString", "pokemon_debug"})
public final class PokemonDetail {
    @com.google.gson.annotations.SerializedName(value = "id")
    private final int id = 0;
    @com.google.gson.annotations.SerializedName(value = "name")
    @org.jetbrains.annotations.NotNull()
    private final java.lang.String name = null;
    @com.google.gson.annotations.SerializedName(value = "height")
    private final int height = 0;
    @com.google.gson.annotations.SerializedName(value = "weight")
    private final int weight = 0;
    @com.google.gson.annotations.SerializedName(value = "base_experience")
    @org.jetbrains.annotations.Nullable()
    private final java.lang.Integer baseExperience = null;
    @com.google.gson.annotations.SerializedName(value = "sprites")
    @org.jetbrains.annotations.NotNull()
    private final com.example.ud1_modularization_example_2.data.pokemon.model.PokemonSprites sprites = null;
    @com.google.gson.annotations.SerializedName(value = "types")
    @org.jetbrains.annotations.NotNull()
    private final java.util.List<com.example.ud1_modularization_example_2.data.pokemon.model.PokemonType> types = null;
    @com.google.gson.annotations.SerializedName(value = "stats")
    @org.jetbrains.annotations.NotNull()
    private final java.util.List<com.example.ud1_modularization_example_2.data.pokemon.model.PokemonStat> stats = null;
    @com.google.gson.annotations.SerializedName(value = "abilities")
    @org.jetbrains.annotations.NotNull()
    private final java.util.List<com.example.ud1_modularization_example_2.data.pokemon.model.PokemonAbility> abilities = null;
    
    public PokemonDetail(int id, @org.jetbrains.annotations.NotNull()
    java.lang.String name, int height, int weight, @org.jetbrains.annotations.Nullable()
    java.lang.Integer baseExperience, @org.jetbrains.annotations.NotNull()
    com.example.ud1_modularization_example_2.data.pokemon.model.PokemonSprites sprites, @org.jetbrains.annotations.NotNull()
    java.util.List<com.example.ud1_modularization_example_2.data.pokemon.model.PokemonType> types, @org.jetbrains.annotations.NotNull()
    java.util.List<com.example.ud1_modularization_example_2.data.pokemon.model.PokemonStat> stats, @org.jetbrains.annotations.NotNull()
    java.util.List<com.example.ud1_modularization_example_2.data.pokemon.model.PokemonAbility> abilities) {
        super();
    }
    
    public final int getId() {
        return 0;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.lang.String getName() {
        return null;
    }
    
    public final int getHeight() {
        return 0;
    }
    
    public final int getWeight() {
        return 0;
    }
    
    @org.jetbrains.annotations.Nullable()
    public final java.lang.Integer getBaseExperience() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final com.example.ud1_modularization_example_2.data.pokemon.model.PokemonSprites getSprites() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.util.List<com.example.ud1_modularization_example_2.data.pokemon.model.PokemonType> getTypes() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.util.List<com.example.ud1_modularization_example_2.data.pokemon.model.PokemonStat> getStats() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.util.List<com.example.ud1_modularization_example_2.data.pokemon.model.PokemonAbility> getAbilities() {
        return null;
    }
    
    public final int component1() {
        return 0;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.lang.String component2() {
        return null;
    }
    
    public final int component3() {
        return 0;
    }
    
    public final int component4() {
        return 0;
    }
    
    @org.jetbrains.annotations.Nullable()
    public final java.lang.Integer component5() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final com.example.ud1_modularization_example_2.data.pokemon.model.PokemonSprites component6() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.util.List<com.example.ud1_modularization_example_2.data.pokemon.model.PokemonType> component7() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.util.List<com.example.ud1_modularization_example_2.data.pokemon.model.PokemonStat> component8() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.util.List<com.example.ud1_modularization_example_2.data.pokemon.model.PokemonAbility> component9() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final com.example.ud1_modularization_example_2.data.pokemon.model.PokemonDetail copy(int id, @org.jetbrains.annotations.NotNull()
    java.lang.String name, int height, int weight, @org.jetbrains.annotations.Nullable()
    java.lang.Integer baseExperience, @org.jetbrains.annotations.NotNull()
    com.example.ud1_modularization_example_2.data.pokemon.model.PokemonSprites sprites, @org.jetbrains.annotations.NotNull()
    java.util.List<com.example.ud1_modularization_example_2.data.pokemon.model.PokemonType> types, @org.jetbrains.annotations.NotNull()
    java.util.List<com.example.ud1_modularization_example_2.data.pokemon.model.PokemonStat> stats, @org.jetbrains.annotations.NotNull()
    java.util.List<com.example.ud1_modularization_example_2.data.pokemon.model.PokemonAbility> abilities) {
        return null;
    }
    
    @java.lang.Override()
    public boolean equals(@org.jetbrains.annotations.Nullable()
    java.lang.Object other) {
        return false;
    }
    
    @java.lang.Override()
    public int hashCode() {
        return 0;
    }
    
    @java.lang.Override()
    @org.jetbrains.annotations.NotNull()
    public java.lang.String toString() {
        return null;
    }
}