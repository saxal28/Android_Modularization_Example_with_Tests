# Pokemon App - Modularization Example

A modern Android application demonstrating clean architecture principles and multi-module
organization using Jetpack Compose, Hilt dependency injection, and navigation.

## 🏗️ Architecture

This application follows **Clean Architecture** principles with clear separation of concerns across
multiple modules:

### Architectural Layers

- **Presentation Layer**: UI components built with Jetpack Compose
- **Domain Layer**: Business logic and use cases (implicit in feature modules)
- **Data Layer**: Repository pattern with remote data sources

### Key Architectural Patterns

- **MVVM (Model-View-ViewModel)**: For presentation layer logic
- **Repository Pattern**: For data abstraction
- **Dependency Injection**: Using Dagger Hilt for IoC
- **Single Activity Architecture**: Navigation handled by Jetpack Navigation Compose

## 📦 Modularization Strategy

The project follows a **feature-based modularization** approach with shared core modules:

```
├── app/                          # Main application module
├── feature/
│   ├── pokedex/                 # Pokemon list feature
│   └── pokemon_detail/          # Pokemon detail feature
├── data/
│   └── pokemon/                 # Pokemon data layer
└── core/
    ├── data/                    # Shared data utilities
    └── ui/                      # Shared UI components
```

### Module Responsibilities

#### `:app` (Application Module)

- Main entry point and navigation setup
- Theme configuration
- Dependency injection initialization
- Activity hosting

#### `:feature:pokedex` (Feature Module)

- Pokemon list UI and presentation logic
- ViewModel for list state management
- Navigation to detail screen

#### `:feature:pokemon_detail` (Feature Module)

- Pokemon detail UI and presentation logic
- ViewModel for detail state management
- Back navigation handling

#### `:data:pokemon` (Data Module)

- Pokemon repository implementation
- API service definitions
- Data models and DTOs
- Network layer abstraction

#### `:core:data` (Core Data Module)

- Shared networking utilities
- Common data layer configurations
- Retrofit setup and interceptors

#### `:core:ui` (Core UI Module)

- Shared UI components
- Common theming utilities
- Reusable composables

### Module Dependencies

```
app
├── feature:pokedex
├── feature:pokemon_detail
├── data:pokemon
└── core:data

feature:pokedex
├── data:pokemon
└── core:ui

feature:pokemon_detail
├── data:pokemon
└── core:ui

data:pokemon
└── core:data
```

## 🛠️ Libraries & Tools

### Core Android

- **Kotlin**: 2.0.21
- **Android Gradle Plugin**: 8.10.0
- **Min SDK**: 24, **Target SDK**: 35
- **Java Version**: 11

### UI Framework

- **Jetpack Compose**: BOM 2024.09.00
- **Material 3**: Latest from Compose BOM
- **Navigation Compose**: 2.8.5
- **Activity Compose**: 1.10.1

### Architecture Components

- **Lifecycle ViewModel Compose**: 2.9.0
- **Lifecycle Runtime KTX**: 2.9.0

### Dependency Injection

- **Dagger Hilt**: 2.51.1
- **Hilt Navigation Compose**: 1.2.0

### Networking

- **Retrofit**: 2.9.0
- **OkHttp Logging Interceptor**: 4.12.0
- **Gson Converter**: 2.9.0
- **Gson**: 2.10.1

### Image Loading

- **Coil Compose**: 2.6.0

### Testing

- **JUnit**: 4.13.2
- **Android Test JUnit**: 1.2.1
- **Espresso**: 3.6.1
- **Compose UI Testing**: Latest from Compose BOM
- **MockK**: 1.13.8
- **Kotlinx Coroutines Test**: 1.7.3

### Build Configuration

- **Version Catalog**: Centralized dependency management
- **Kotlin Compose Compiler Plugin**: 2.0.21

## 🧪 Testing Strategy

This project implements comprehensive testing across data, core, and feature modules with a focus
on:

### Testing Framework & Libraries

- **JUnit 4**: Primary testing framework
- **MockK**: Kotlin-first mocking library for creating test doubles
- **Kotlinx Coroutines Test**: Testing utilities for coroutines and suspend functions
- **Gson**: For JSON serialization/deserialization testing
- **Jetpack Compose UI Testing**: For UI component and integration testing
- **AndroidJUnit4**: Android-specific testing runner for instrumented tests

### Test Coverage by Module

#### `:data:pokemon` Module Tests

**PokemonRepositoryTest**: Comprehensive repository layer testing

- ✅ Success scenarios for all API endpoints
- ✅ Exception handling and error propagation
- ✅ Default parameter validation
- ✅ Coroutine-based suspend function testing
- ✅ Mock verification of API service calls

**PokemonListItemTest**: Data model validation

- ✅ URL parsing for Pokemon ID extraction
- ✅ Image URL generation logic
- ✅ Edge cases for malformed URLs
- ✅ Null handling scenarios

**PokemonModelSerializationTest**: JSON serialization testing

- ✅ Complete Pokemon data model serialization/deserialization
- ✅ Real API JSON format compatibility
- ✅ Null value handling (e.g., nullable baseExperience)
- ✅ Nested object serialization (sprites, types, stats, abilities)

**PokemonDataModuleTest**: Dependency injection validation

- ✅ Service creation with correct base URL
- ✅ Retrofit builder configuration
- ✅ Module provider method testing

#### `:core:data` Module Tests

**NetworkModuleTest**: Network configuration testing

- ✅ HTTP logging interceptor configuration
- ✅ OkHttp client timeout settings (30s connect/read/write)
- ✅ Retrofit builder setup with Gson converter
- ✅ Integration testing of complete network stack
- ✅ Dependency injection module validation

#### `:feature:pokedex` Module Tests

**PokedexScreenTest**: Comprehensive UI testing (16 tests)

- ✅ **Header Display**: Pokédex title and Pokeball icon visibility
- ✅ **Search Interface**: Search bar and sort button functionality
- ✅ **Loading States**: CircularProgressIndicator behavior during data loading
- ✅ **Pokemon Data Display**: Names, IDs (#001 format), and images
- ✅ **Error Handling**: Error messages and retry button functionality
- ✅ **Search Functionality**: Text filtering and case-insensitive search
- ✅ **User Interactions**: Pokemon card clicks and navigation callbacks
- ✅ **State Management**: Loading, success, error, and empty states
- ✅ **Grid Layout**: Multiple Pokemon cards display correctly
- ✅ **Data Validation**: Correct Pokemon count and information display

**PokemonCard Component Tests**:

- ✅ Individual card display (name, ID, image)
- ✅ Click interactions and callback execution
- ✅ Proper image content descriptions for accessibility

#### `:feature:pokemon_detail` Module Tests

**Note**: UI testing for Pokemon Detail screen requires complex Hilt dependency injection setup for
ViewModel testing. The module contains:

- **Complex UI Components**: Type chips, stat bars, attribute displays
- **State Management**: Loading, error, and content states
- **Dynamic Background Colors**: Based on Pokemon primary type
- **Scrollable Content**: About section, stats, and abilities
- **Image Loading**: Pokemon sprites with network requests

**Testing Approach**:

- Unit tests can be added for individual composable components
- Integration tests require custom Hilt test setup
- Manual testing recommended for full user journey validation

### UI Testing Patterns & Best Practices

#### Test Structure Pattern

```kotlin
@Test
fun componentName_expectedBehavior_whenCondition() {
    // Given - Setup test data and initial state
    val testData = SampleData()

    // When - Execute the component under test
    composeTestRule.setContent {
        ComponentUnderTest(
            data = testData,
            onAction = { /* callback verification */ }
        )
    }

    // Then - Verify expected UI state and interactions
    composeTestRule.onNodeWithText("Expected Text").assertIsDisplayed()
    composeTestRule.onNodeWithContentDescription("Action").performClick()
}
```

#### UI Testing Best Practices

1. **Semantic Testing**: Use content descriptions and semantic properties
2. **State Verification**: Test all UI states (loading, success, error, empty)
3. **User Interactions**: Verify clicks, text input, and navigation callbacks
4. **Accessibility**: Ensure proper content descriptions for screen readers
5. **Data Display**: Validate correct formatting and information presentation

#### Test Organization

- **UI Tests Location**: `src/androidTest/java/`
- **Test Naming**: Descriptive method names with condition context
- **Test Structure**: Given-When-Then pattern for clarity
- **Compose Testing**: `createComposeRule()` for component testing
- **Async Handling**: Proper waiting for UI state changes

### Testing Patterns & Best Practices

#### Repository Testing Pattern

```kotlin
@Test
fun `getPokemonList should return success when api call succeeds`() = runTest {
        // Given - Setup mock expectations
        val expectedResponse = PokemonListResponse(...)
        coEvery { apiService.getPokemonList(20, 0) } returns expectedResponse

        // When - Execute the method under test
        val result = repository.getPokemonList(20, 0)

        // Then - Verify results and interactions
        assertTrue(result.isSuccess)
        assertEquals(expectedResponse, result.getOrNull())
        coVerify { apiService.getPokemonList(20, 0) }
    }
```

#### Data Model Testing Pattern

```kotlin
@Test
fun `id should extract correct value from valid url`() {
    // Given - Create test data
    val pokemonItem = PokemonListItem(
        name = "pikachu",
        url = "https://pokeapi.co/api/v2/pokemon/25/"
    )

    // When - Execute computed property
    val id = pokemonItem.id

    // Then - Verify expected result
    assertEquals(25, id)
}
```

#### Serialization Testing Pattern

```kotlin
@Test
fun `PokemonListResponse should deserialize from actual API JSON format`() {
    // Given - Real API JSON structure
    val apiJson = """{ "count": 1302, "results": [...] }"""

    // When - Deserialize using Gson
    val result = gson.fromJson(apiJson, PokemonListResponse::class.java)

    // Then - Verify all fields are correctly mapped
    assertEquals(1302, result.count)
    assertEquals("bulbasaur", result.results[0].name)
}
```

#### Test Organization

- **Unit Tests Location**: `src/test/java/`
- **Test Naming**: Descriptive method names using backticks
- **Test Structure**: Given-When-Then pattern for clarity
- **Mock Strategy**: Use MockK for all external dependencies
- **Async Testing**: Use `runTest` for coroutine-based code

### Running Tests

```bash
# All unit tests
./gradlew test

# All UI tests
./gradlew connectedAndroidTest

# Specific module tests
./gradlew :feature:pokedex:test
./gradlew :feature:pokedex:connectedDebugAndroidTest

# With coverage
./gradlew testDebugUnitTestCoverage
```

### Test Reports and Coverage

Test reports are generated in:

- `{module}/build/reports/tests/testDebugUnitTest/index.html` (Unit tests)
- `{module}/build/reports/androidTests/connected/index.html` (UI tests)

## 🚀 Getting Started

### Prerequisites

- Android Studio Hedgehog or later
- JDK 11 or higher
- Android SDK with API level 35

### Building the Project

```bash
./gradlew build
```

## 🔧 Development Guidelines

### Module Creation

1. Create new module directory structure
2. Add module to `settings.gradle.kts`
3. Configure `build.gradle.kts` with appropriate plugins
4. Define module dependencies carefully to avoid circular references

### Code Style

- Follow Kotlin coding conventions
- Use meaningful package structure
- Implement proper separation of concerns
- Write testable code with dependency injection

### Testing Guidelines

#### Unit Test Requirements

- **Coverage**: Aim for >80% code coverage on business logic
- **Naming**: Use descriptive test names with backticks
- **Structure**: Follow Given-When-Then pattern
- **Mocking**: Use MockK for external dependencies
- **Async**: Use `runTest` for suspend functions

#### Test Categories

1. **Repository Tests**: API integration, error handling, data transformation
2. **Model Tests**: Data validation, computed properties, edge cases
3. **Serialization Tests**: JSON mapping, API compatibility
4. **DI Module Tests**: Dependency creation, configuration validation

#### Writing Effective Tests

```kotlin
class ExampleTest {
    private lateinit var mockDependency: SomeDependency
    private lateinit var systemUnderTest: SystemUnderTest

    @Before
    fun setup() {
        mockDependency = mockk()
        systemUnderTest = SystemUnderTest(mockDependency)
    }

    @Test
    fun `method should handle success case correctly`() = runTest {
        // Given
        val expectedData = TestData()
        coEvery { mockDependency.getData() } returns expectedData

        // When
        val result = systemUnderTest.processData()

        // Then
        assertTrue(result.isSuccess)
        assertEquals(expectedData, result.getOrNull())
        coVerify { mockDependency.getData() }
    }
}
```

## 🎯 Key Features

### Navigation Flow

1. **Pokedex Screen**: Displays list of Pokemon
2. **Pokemon Detail Screen**: Shows detailed information for selected Pokemon

### Dependency Injection Setup

- `@HiltAndroidApp` on Application class
- `@AndroidEntryPoint` on MainActivity
- Module-specific Hilt components for feature isolation

### State Management

- ViewModel per feature with Compose integration
- Hilt-injected ViewModels using `@HiltViewModel`
- Reactive state handling with Compose

## 🏆 Benefits of This Architecture

### Scalability

- Easy to add new features as separate modules
- Independent development and testing of features
- Reduced build times through module-level caching

### Maintainability

- Clear separation of concerns
- Isolated feature development
- Easier code reviews and debugging
- Comprehensive test coverage

### Team Collaboration

- Teams can work on different modules independently
- Reduced merge conflicts
- Clear ownership boundaries
- Testable components

### Performance

- Parallel module compilation
- Incremental builds
- Lazy module loading potential
- Fast test execution

### Quality Assurance

- **High Test Coverage**: Repository, model, and UI component testing
- **Mock-based Testing**: Isolated unit tests without external dependencies
- **Real-world Scenarios**: Tests handle actual API responses and edge cases
- **Continuous Integration Ready**: Fast, reliable test suite
- **UI Verification**: Comprehensive user interface testing for critical user journeys

## 📱 Supported Android Versions

- **Minimum**: Android 7.0 (API 24)
- **Target**: Android 14 (API 35)
- **Compile**: Android 14 (API 35)
