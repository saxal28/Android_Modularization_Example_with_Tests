package com.example.ud1_modularization_example_2.data.pokemon.model;

@kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u000e\n\u0002\u0010\u000b\n\u0002\b\u0004\b\u0086\b\u0018\u00002\u00020\u0001B/\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\b\u0010\u0006\u001a\u0004\u0018\u00010\u0005\u0012\f\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\t0\b\u00a2\u0006\u0002\u0010\nJ\t\u0010\u0012\u001a\u00020\u0003H\u00c6\u0003J\u000b\u0010\u0013\u001a\u0004\u0018\u00010\u0005H\u00c6\u0003J\u000b\u0010\u0014\u001a\u0004\u0018\u00010\u0005H\u00c6\u0003J\u000f\u0010\u0015\u001a\b\u0012\u0004\u0012\u00020\t0\bH\u00c6\u0003J;\u0010\u0016\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u00052\u000e\b\u0002\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\t0\bH\u00c6\u0001J\u0013\u0010\u0017\u001a\u00020\u00182\b\u0010\u0019\u001a\u0004\u0018\u00010\u0001H\u00d6\u0003J\t\u0010\u001a\u001a\u00020\u0003H\u00d6\u0001J\t\u0010\u001b\u001a\u00020\u0005H\u00d6\u0001R\u0016\u0010\u0002\u001a\u00020\u00038\u0006X\u0087\u0004\u00a2\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\fR\u0018\u0010\u0004\u001a\u0004\u0018\u00010\u00058\u0006X\u0087\u0004\u00a2\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000eR\u0018\u0010\u0006\u001a\u0004\u0018\u00010\u00058\u0006X\u0087\u0004\u00a2\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u000eR\u001c\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\t0\b8\u0006X\u0087\u0004\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u0011\u00a8\u0006\u001c"}, d2 = {"Lcom/example/ud1_modularization_example_2/data/pokemon/model/PokemonListResponse;", "", "count", "", "next", "", "previous", "results", "", "Lcom/example/ud1_modularization_example_2/data/pokemon/model/PokemonListItem;", "(ILjava/lang/String;Ljava/lang/String;Ljava/util/List;)V", "getCount", "()I", "getNext", "()Ljava/lang/String;", "getPrevious", "getResults", "()Ljava/util/List;", "component1", "component2", "component3", "component4", "copy", "equals", "", "other", "hashCode", "toString", "pokemon_release"})
public final class PokemonListResponse {
    @com.google.gson.annotations.SerializedName(value = "count")
    private final int count = 0;
    @com.google.gson.annotations.SerializedName(value = "next")
    @org.jetbrains.annotations.Nullable()
    private final java.lang.String next = null;
    @com.google.gson.annotations.SerializedName(value = "previous")
    @org.jetbrains.annotations.Nullable()
    private final java.lang.String previous = null;
    @com.google.gson.annotations.SerializedName(value = "results")
    @org.jetbrains.annotations.NotNull()
    private final java.util.List<com.example.ud1_modularization_example_2.data.pokemon.model.PokemonListItem> results = null;
    
    public PokemonListResponse(int count, @org.jetbrains.annotations.Nullable()
    java.lang.String next, @org.jetbrains.annotations.Nullable()
    java.lang.String previous, @org.jetbrains.annotations.NotNull()
    java.util.List<com.example.ud1_modularization_example_2.data.pokemon.model.PokemonListItem> results) {
        super();
    }
    
    public final int getCount() {
        return 0;
    }
    
    @org.jetbrains.annotations.Nullable()
    public final java.lang.String getNext() {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable()
    public final java.lang.String getPrevious() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.util.List<com.example.ud1_modularization_example_2.data.pokemon.model.PokemonListItem> getResults() {
        return null;
    }
    
    public final int component1() {
        return 0;
    }
    
    @org.jetbrains.annotations.Nullable()
    public final java.lang.String component2() {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable()
    public final java.lang.String component3() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.util.List<com.example.ud1_modularization_example_2.data.pokemon.model.PokemonListItem> component4() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final com.example.ud1_modularization_example_2.data.pokemon.model.PokemonListResponse copy(int count, @org.jetbrains.annotations.Nullable()
    java.lang.String next, @org.jetbrains.annotations.Nullable()
    java.lang.String previous, @org.jetbrains.annotations.NotNull()
    java.util.List<com.example.ud1_modularization_example_2.data.pokemon.model.PokemonListItem> results) {
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